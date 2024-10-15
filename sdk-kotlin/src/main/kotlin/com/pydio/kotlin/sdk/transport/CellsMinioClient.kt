package com.pydio.kotlin.sdk.transport

import com.pydio.kotlin.sdk.api.ProgressListener
import com.pydio.kotlin.sdk.api.S3Names
import io.minio.MinioClient
import io.minio.PutObjectArgs
import java.io.ByteArrayInputStream
import java.nio.charset.StandardCharsets

/* Main entry point to communicate with a S3 store */
class CellsMinioClient(private val transport: CellsTransport) {

    private val logTag = "CellsMinioClient.kt"

    fun getMinioClient(transport: CellsTransport): MinioClient {
        val minioClient = MinioClient.builder().httpClient(transport.authenticatedClient().build())
            .endpoint(transport.server.url())
            .credentials(transport.accessToken, DEFAULT_GATEWAY_SECRET)
            .build()
        return minioClient
    }

    suspend fun upload(
        stateID: StateID,
        content: String,
        mime: String = S3Names.S3_CONTENT_TYPE_OCTET_STREAM,
        progressListener: ProgressListener?
    ) {
        println("#### About to upload with Minio")
        val minioClient = getMinioClient(transport)
        val path = stateID.path?.substring(1) ?: ""
        val args = PutObjectArgs.builder().bucket(DEFAULT_BUCKET_NAME).`object`(path)
            .stream(
                ByteArrayInputStream(content.toByteArray(StandardCharsets.UTF_8)),
                content.length.toLong(),
                -1L
            )
            .contentType(mime)
            .build()
        minioClient.putObject(args)
    }
}

//private class SimpleCredentialsProvider(private val transport: CellsTransport) :
//    CredentialsProvider {
//
//    override suspend fun resolve(attributes: Attributes): Credentials {
//        if (transport.accessToken == null) {
//            throw IllegalArgumentException("access token cannot be null")
//        }
//        return Credentials(
//            accessKeyId = transport.accessToken!!,
//            secretAccessKey = DEFAULT_GATEWAY_SECRET,
//            sessionToken = transport.accessToken
//        )
//    }
//}
