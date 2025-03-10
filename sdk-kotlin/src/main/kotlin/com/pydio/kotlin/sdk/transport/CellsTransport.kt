package com.pydio.kotlin.sdk.transport

import com.pydio.kotlin.openapi.api.FrontendServiceApi
import com.pydio.kotlin.openapi.model.RestFrontSessionRequest
import com.pydio.kotlin.openapi.model.RestFrontSessionResponse
import com.pydio.kotlin.sdk.api.CustomEncoder
import com.pydio.kotlin.sdk.api.ErrorCodes
import com.pydio.kotlin.sdk.api.PasswordCredentials
import com.pydio.kotlin.sdk.api.SDKException
import com.pydio.kotlin.sdk.api.SdkNames
import com.pydio.kotlin.sdk.api.Server
import com.pydio.kotlin.sdk.api.ServerURL
import com.pydio.kotlin.sdk.api.Transport
import com.pydio.kotlin.sdk.transport.auth.CellsAnonInterceptor
import com.pydio.kotlin.sdk.transport.auth.CellsOAuthInterceptor
import com.pydio.kotlin.sdk.transport.auth.CredentialService
import com.pydio.kotlin.sdk.transport.auth.Token
import com.pydio.kotlin.sdk.transport.auth.jwt.OAuthConfig
import com.pydio.kotlin.sdk.utils.IoHelpers
import com.pydio.kotlin.sdk.utils.Log
import okhttp3.OkHttpClient
import java.io.ByteArrayOutputStream
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URI
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

class CellsTransport(
    private val credentialService: CredentialService?,
    // TODO rather rely on a state ID
    override val username: String,
    override val server: Server,
    private val encoder: CustomEncoder
) : Transport, SdkNames {

    private val timeFormatter: SimpleDateFormat = SimpleDateFormat("HH:mm")
    private var userAgent: String? = null

    override val id: String
        get() = stateID.id
    override val stateID: StateID
        get() = StateID(username, server.serverURL.id)
    override val isOffline: Boolean
        get() {
            Log.w(logTag, "Hard-coded non relevant offline check from ")
            Thread.dumpStack()
            return false
        }

    override fun getUserAgent(): String {
        userAgent?.let { return it }

        val agent = ClientData.getInstance().userAgent()
        userAgent = agent
        Log.i(logTag, "New Transport instance for $username, user agent is: [$agent]")
        return agent
    }

    override fun apiConf(): Pair<String, OkHttpClient> {
        return getApiURL() to authenticatedClient().build()
    }

    override fun anonApiConf(): Pair<String, OkHttpClient> {
        return getApiURL() to anonClient().build()
    }

    override fun getApiURL(): String {
        return getApiURL(server.serverURL)
    }

    fun getToken(): Token? {
        return credentialService?.get(id)
    }

    @Throws(SDKException::class)
    fun requestTokenRefresh() {
        credentialService?.requestRefreshToken(stateID)
    }

    @Throws(SDKException::class)
    override fun getServerRegistryAsNonAuthenticatedUser(): InputStream? {
        try {
            val con = openAnonymousApiConnection(registryPath)
            con.requestMethod = "GET"
            return con.inputStream
        } catch (e: IOException) {
            throw SDKException.conFailed("cannot get registry as anonymous", e)
        }
    }

    @Throws(SDKException::class)
    override fun getServerRegistryAsAuthenticatedUser(): InputStream? {
        try {
            val con = openApiConnection(registryPath)
            con.requestMethod = "GET"
            return con.inputStream
        } catch (e: IOException) {
            e.printStackTrace()
            throw SDKException.conFailed("cannot get registry as authenticated user", e)
        }
    }

    @get:Throws(SDKException::class)
    val accessToken: String?
        get() {
            val token = checkedToken ?: return null
            return token.value
        }

    override fun getUserData(binary: String?): InputStream? {
        // FIXME  implement
        return null
    }

    @Throws(SDKException::class)
    override fun withAuth(con: HttpURLConnection): HttpURLConnection {
        con.setRequestProperty("Authorization", "Bearer $accessToken")
        return con
    }

    override fun withUserAgent(con: HttpURLConnection): HttpURLConnection {
        con.setRequestProperty("User-Agent", userAgent)
        return con
    }

    @Throws(SDKException::class, IOException::class)
    override fun openConnection(path: String): HttpURLConnection {
        return withAuth(withUserAgent(server.newURL(path).openConnection()))
    }

    @Throws(IOException::class)
    override fun openAnonConnection(path: String): HttpURLConnection {
        return withUserAgent(server.newURL(path).openConnection())
    }

    @Throws(SDKException::class, IOException::class)
    fun openApiConnection(path: String): HttpURLConnection {
        return withAuth(
            withUserAgent(
                server.newURL(CellsServer.API_PREFIX + path).openConnection()
            )
        )
    }

    @Throws(IOException::class)
    fun openAnonymousApiConnection(path: String): HttpURLConnection {
        return withUserAgent(server.newURL(CellsServer.API_PREFIX + path).openConnection())
    }

    @Throws(SDKException::class)
    fun authenticatedClient(): OkHttpClient.Builder {
        var builder = OkHttpClient.Builder().addInterceptor(
            CellsOAuthInterceptor(getUserAgent()) {
                val t = this.getToken()
                val idt = t?.value
                if (idt.isNullOrEmpty()) throw SDKException(ErrorCodes.no_token_available)
                idt
            }
        )

        if (server.isSSLUnverified) {
            builder = withSkipVerify(builder)
        }

        return builder
    }

    fun withSkipVerify(builder: OkHttpClient.Builder): OkHttpClient.Builder {
        // Create a trust manager that does not validate certificate chains
        val trustAllCerts = arrayOf<TrustManager>(
            object : X509TrustManager {
                override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
                override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {}
                override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {}
            }
        )

        // Install the all-trusting trust manager
        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, SecureRandom())

        // Create an ssl socket factory with our all-trusting manager
        val sslSocketFactory = sslContext.socketFactory

        return builder
            .sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            .hostnameVerifier { _, _ -> true }
    }

    @Throws(SDKException::class)
    fun anonClient(): OkHttpClient.Builder {
        var builder = OkHttpClient.Builder().addInterceptor(
            CellsAnonInterceptor(getUserAgent())
        )

        if (server.isSSLUnverified) {
            builder = withSkipVerify(builder)
        }
        return builder
    }

//    val apiClient: ApiClient
//        get() {
////            var apiClient = ApiClient()
////            if (server.isSSLUnverified) {
////                apiClient = apiClient.setVerifyingSsl(false)
////            }
////            apiClient.setBasePath(getApiURL(server.serverURL))
////            apiClient.setUserAgent(userAgent)
////            return apiClient
//            // TODO configure default okhttp client
//
//            val builder = OkHttpClient.Builder().addInterceptor(
//                CellsOAuthInterceptor {
//                    Log.e(logTag, "In CellsOAuthInterceptor")
//                    val t = this.getToken()
//                    val idt = t?.value
//                    Log.e(logTag, "    Got a token: $idt")
//                    idt
//                }
//            )
//            // TODO handle skip verify
////            if (server.isSSLUnverified) {
////                apiClient = apiClient.setVerifyingSsl(false)
////            }
//            // TODO handle user agent
//            // apiClient.setUserAgent(userAgent)
//
//            return ApiClient(getApiURL(), builder.build())
//        }

    @Throws(Exception::class)
    fun tryDownloadingBootConf() {
        var con: HttpURLConnection? = null
        var inputStream: InputStream? = null
        val out = ByteArrayOutputStream()
        try {
            con = openConnection(CellsServer.BOOTCONF_PATH)
            inputStream = con.inputStream
            IoHelpers.pipeRead(inputStream, out)
        } finally {
            IoHelpers.closeQuietly(con)
            IoHelpers.closeQuietly(inputStream)
            IoHelpers.closeQuietly(out)
        }
    }

    @Throws(SDKException::class)
    override fun getTokenFromLegacyCredentials(credentials: PasswordCredentials): Token {
        val authInfo: MutableMap<String, String> = HashMap()
        authInfo["login"] = credentials.getUsername()
        authInfo["password"] = credentials.getPassword()
        authInfo["type"] = "credentials"
        val cd = ClientData.getInstance()
        authInfo["client_id"] = cd.clientID
        if (cd.clientSecret.isNotEmpty()) {
            // This additional header is only used for "private" clients and not used with
            // default standard clients that have no client secret
            val authHeader = ("Basic "
                    + encoder.base64Encode(cd.clientID + ":" + cd.clientSecret))
            authInfo["Authorization"] = authHeader
        }
        val request = RestFrontSessionRequest(
            authInfo = authInfo,
            clientTime = System.currentTimeMillis().toInt(),
        )
        val api = FrontendServiceApi(getApiURL(), anonClient().build())
        val response: RestFrontSessionResponse
        return try {
            response = api.frontSession(request)
            val t = Token()
            t.subject = ServerFactory.accountID(credentials.getUsername(), server).id
            t.value = response.JWT
            // t.value = response.token?.idToken
            response.expireTime?.let { t.setExpiry(it.toLong()) }
            t
        } catch (e: Exception) { // TODO was ApiException
            throw IllegalStateException("cannot retrieve token with legacy credentials", e)
//            throw SDKException(
//                ErrorCodes.no_token_available,
//                IOException("login or password incorrect")
//            )
        }
    }

    // TODO better management of exceptions.
    @Throws(Exception::class)
    fun getTokenFromCode(code: String, encoder: CustomEncoder?): Token {
        var input: InputStream? = null
        val cfg: OAuthConfig = server.oAuthConfig
            ?: throw IllegalStateException("No OAuth config is defined for ${server.serverURL.id}")

        return try {
            Log.i(logTag, "Retrieving token from OAuth2 code")
            val endpointURI = URI.create(cfg.tokenEndpoint)
            val con = openAnonConnection(endpointURI.path)

            // Manage Body as URL encoded form
            val authData: MutableMap<String, String> = HashMap()
            authData["grant_type"] = "authorization_code"
            authData["code"] = code
            authData["redirect_uri"] = cfg.redirectURI
            val cd = ClientData.getInstance()
            authData["client_id"] = cd.clientID
            if (cd.clientSecret.isNotEmpty()) {
                authData["client_secret"] = cd.clientSecret
            }
            addPostData(con, authData, null)
            input = try { // Real call
                // TODO double check: do we need to explicitly open the connection before getting the stream ?
                con.connect()
                con.inputStream
            } catch (ioe: IOException) {
                throw IOException("Unable to open connection to $endpointURI", ioe)
            }
            val jwtStr = IoHelpers.readToString(input!!)
            Token.decodeOAuthJWT(jwtStr)
        } finally {
            IoHelpers.closeQuietly(input)
        }
    }

    @Throws(SDKException::class)
    fun getRefreshedOAuthToken(refreshToken: String): Token {
        var input: InputStream? = null
        val cfg: OAuthConfig = server.oAuthConfig
            ?: throw IllegalStateException("No OAuth config is defined for ${server.serverURL.id}")

        return try {
            val msg = "Launching refresh token flow for $username@${server.url()}"
            Log.d(logTag, msg)
            val endpointURI = URI.create(cfg.tokenEndpoint)
            val con = openAnonConnection(endpointURI.path)
            val authData: MutableMap<String, String> = HashMap()
            authData["grant_type"] = "refresh_token"
            authData["refresh_token"] = refreshToken
            val cd = ClientData.getInstance()
            authData["client_id"] = cd.clientID
            if (cd.clientSecret.isNotEmpty()) {
                authData["client_secret"] = cd.clientSecret
            }
            addPostData(con, authData, null)
            input = con.inputStream
            val jwtStr = IoHelpers.readToString(input)
            val newToken = Token.decodeOAuthJWT(jwtStr)
            Log.i(
                logTag, String.format(
                    "Retrieved a refreshed token for %s@%s. New expiration time %s",
                    username,
                    server.url(),
                    timeFormatter.format(Date(newToken.expirationTime * 1000L))
                )
            )
            newToken
        } catch (e: ParseException) {
            Log.e(logTag, "Could not parse refreshed token. " + e.localizedMessage)
            throw SDKException(
                ErrorCodes.no_token_available,
                IOException("could not decode server response")
            )
        } catch (e: IOException) {
            if (e is FileNotFoundException) {
                throw SDKException(
                    ErrorCodes.refresh_token_not_valid,
                    "FNFE while trying to refresh. It usually means that the refresh token has already been consumed",
                    e
                )
            } else {
                throw SDKException.RemoteIOException("Token request failed: " + e.localizedMessage)
            }
        } finally {
            IoHelpers.closeQuietly(input)
        }
    }

    @get:Throws(SDKException::class)
    private val checkedToken: Token?
        get() {
            if (credentialService == null) {
                return null
            }
            val token: Token? = credentialService[id]
            // We check token validity and try to refresh / get it if necessary
            if (token == null) {
                return null
            } else if (token.isExpired) {
                // Initiate a refresh token request if non is already running, but do not retrieve a new valid token here.
                credentialService.requestRefreshToken(stateID)
                throw SDKException(
                    ErrorCodes.token_expired,
                    "Token expired for $stateID, refresh has been requested"
                )
            }
            return token
        }

    /* Sets body parameters as URL encoded form */
    @Throws(SDKException::class)
    private fun addPostData(
        con: HttpURLConnection,
        postData: Map<String, String>,
        authHeader: String?
    ) {
        var postOut: OutputStream? = null
        try {
            con.requestMethod = "POST"
            con.doOutput = true
            con.setRequestProperty(
                "content-type",
                "application/x-www-form-urlencoded; charset=utf-8"
            )

            authHeader?.let {
                if (it.isNotEmpty()) {
                    con.setRequestProperty("Authorization", authHeader)
                }
            }
            val builder = StringBuilder()
            for ((key, value) in postData) {
                if (builder.isNotEmpty()) builder.append('&')
                builder.append(encoder.utf8Encode(key))
                builder.append('=')
                builder.append(encoder.utf8Encode(value))
            }
            val postDataBytes: ByteArray = encoder.getUTF8Bytes(builder.toString())
            con.setRequestProperty("content-length", postDataBytes.size.toString())
            postOut = con.outputStream
            postOut.write(postDataBytes)
        } catch (e: IOException) {
            throw SDKException(ErrorCodes.bad_config, e)
        } finally {
            IoHelpers.closeQuietly(postOut)
        }
    }

    private fun getApiURL(serverURL: ServerURL): String {
        return try {
            serverURL.withPath(CellsServer.API_PREFIX).url.toString()
        } catch (e: MalformedURLException) {
            throw RuntimeException("Getting API URL for " + serverURL.id, e)
        }
    }

    @Suppress("unused")
    private fun debugConnection(con: HttpURLConnection) {
        println("... Debugging " + con.requestMethod + " connection: ")
        val hfs = con.headerFields
        for (currHeader in hfs.keys) {
            println("--- $currHeader")
            var ii = 0
            for (`val` in hfs[currHeader]!!) {
                println("#" + ++ii + ": " + `val`)
            }
        }
        val headers = con.requestProperties
        for (currHeader in headers.keys) {
            println("--- $currHeader")
            var ii = 0
            for (`val` in headers[currHeader]!!) {
                println("#" + ++ii + ": " + `val`)
            }
        }
    }

    companion object {
        private const val logTag = "CellsTransport"
        private const val registryPath = "/frontend/state"
        fun asAnonymous(server: Server, encoder: CustomEncoder): CellsTransport {
            return CellsTransport(null, Transport.ANONYMOUS_USERNAME, server, encoder)
        }
    }
}
