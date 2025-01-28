import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

const val SERVER_URL = "https://localhost:8080"
private const val PAT = "change me"

private const val SKIP_SSL_VERIFICATION = true

private const val USER_AGENT = "com.pydio.kotlin.openapi.kmp/v0.1.1 CellsAPI/v2"
private const val AUTH_HEADER = "Authorization"
private const val USER_AGENT_HEADER = "User-Agent"
private const val DEFAULT_TOKEN_TYPE = "Bearer"

// const val DEFAULT_GATEWAY_SECRET = "gatewaysecret"
// const val DEFAULT_S3_REGION_NAME = "us-east-1"
// const val DEFAULT_BUCKET_NAME = "io"

fun getMyHttpClient(): HttpClient {
    return HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(jsonInstance)
        }
        engine {
            preconfigured = OkHttpClient.Builder()
                .sslSocketFactory(getSslContext().socketFactory, UnsecureTrustManager())
                .hostnameVerifier { _, _ -> true }
                .addInterceptor(DummyPatInterceptor(USER_AGENT) { PAT })
                .build()
        }
    }
}

@OptIn(ExperimentalSerializationApi::class)
private val jsonInstance = Json {
    ignoreUnknownKeys = true
    isLenient = true
    encodeDefaults = true
    coerceInputValues = false
    explicitNulls = false
}

// SSL context that uses the unsecured trust manager
private var currContext: SSLContext? = null

fun getSslContext(): SSLContext {
    if (currContext != null) {
        return currContext!!
    }
    currContext = SSLContext.getInstance("TLS").apply {
        init(null, arrayOf<TrustManager>(trustAllCerts), SecureRandom())

    }
    return currContext!!
}

// Trust manager that does not validate any certificates
private val trustAllCerts = UnsecureTrustManager()

private class UnsecureTrustManager : X509TrustManager {
    override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
    }

    override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
    }

    override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
}

private class DummyPatInterceptor(
    private val userAgent: String,
    private val getToken: () -> String,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
            .addHeader(AUTH_HEADER, "$DEFAULT_TOKEN_TYPE ${getToken()}")
            .addHeader("User-Agent", userAgent)
        return chain.proceed(builder.build())
    }
}

fun unique(length: Int = 4): String {
    return System.currentTimeMillis().toString().takeLast(length)
}
