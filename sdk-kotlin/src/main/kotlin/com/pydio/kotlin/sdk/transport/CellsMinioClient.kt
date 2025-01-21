package com.pydio.kotlin.sdk.transport

///* Provide basic file transfer capabilities to Cells S3 storage without introducing dependencies to AWS or Android */
//class CellsMinioClient(private val transport: CellsTransport) {
//
//    private val logTag = "CellsMinioClient.kt"
//
//    fun getMinioClient(transport: CellsTransport): MinioClient {
//        val minioClient = MinioClient.builder().httpClient(transport.authenticatedClient().build())
//            .endpoint(transport.server.url())
//            .credentials(transport.accessToken, DEFAULT_GATEWAY_SECRET)
//            .build()
//        return minioClient
//    }
//
//    suspend fun upload(
//        stateID: StateID,
//        content: String,
//        mime: String = S3Names.S3_CONTENT_TYPE_OCTET_STREAM,
//        progressListener: ProgressListener?
//    ) {
//        val minioClient = getMinioClient(transport)
//        val path = stateID.path?.substring(1) ?: ""
//        val args = PutObjectArgs.builder().bucket(DEFAULT_BUCKET_NAME).`object`(path)
//            .stream(
//                ByteArrayInputStream(content.toByteArray(StandardCharsets.UTF_8)),
//                content.length.toLong(),
//                -1L
//            )
//            .contentType(mime)
//            .build()
//        minioClient.putObject(args)
//    }
//
//    suspend fun download(
//        stateID: StateID,
//        outputStream: OutputStream,
//        progressListener: ProgressListener?
//    ) {
//        val minioClient = getMinioClient(transport)
//        val path = stateID.path?.substring(1) ?: ""
//        val args = GetObjectArgs.builder().bucket(DEFAULT_BUCKET_NAME)
//            .`object`(path)
//            .build()
//        val stream: InputStream
//        try {
//            stream = minioClient.getObject(args)
//            IoHelpers.pipeReadWithProgress(stream, outputStream, progressListener)
//        } catch (e: Exception) {
//            println("Could not DL file at $stateID")
//            e.printStackTrace()
//        }
//    }
//}
