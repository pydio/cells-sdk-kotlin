package com.example.s3

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import software.amazon.awssdk.core.exception.SdkException
import software.amazon.awssdk.core.sync.RequestBody
import software.amazon.awssdk.services.s3.S3AsyncClient
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadRequest
import software.amazon.awssdk.services.s3.model.CompletedMultipartUpload
import software.amazon.awssdk.services.s3.model.CompletedPart
import software.amazon.awssdk.services.s3.model.CreateBucketRequest
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadRequest
import software.amazon.awssdk.services.s3.model.DeleteBucketRequest
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest
import software.amazon.awssdk.services.s3.model.HeadBucketRequest
import software.amazon.awssdk.services.s3.model.PutObjectRequest
import software.amazon.awssdk.services.s3.model.UploadPartRequest
import software.amazon.awssdk.transfer.s3.S3TransferManager
import software.amazon.awssdk.transfer.s3.model.UploadFileRequest
import java.io.IOException
import java.io.RandomAccessFile
import java.lang.RuntimeException
import java.net.URISyntaxException
import java.net.URL
import java.nio.ByteBuffer
import java.nio.file.Paths
import java.util.ArrayList
import java.util.Objects
import java.util.UUID
import java.util.function.Consumer


// BS Test with the Java SDK. We probably also have problems to get a standard S3 client...

class MultiPartUpload {

    /**
     * Uploads a file to an Amazon S3 bucket using the S3TransferManager.
     *
     * @param filePath the file path of the file to be uploaded
     */
    fun multipartUploadWithTransferManager(filePath: String) {
        val transferManager = S3TransferManager.create()
        val uploadFileRequest = UploadFileRequest.builder()
            .putObjectRequest(Consumer { b: PutObjectRequest.Builder? ->
                b!!
                    .bucket(bucketName)
                    .key(key)
            })
            .source(Paths.get(filePath))
            .build()
        val fileUpload = transferManager.uploadFile(uploadFileRequest)
        fileUpload.completionFuture().join()
        transferManager.close()
    }

    /**
     * Performs a multipart upload to Amazon S3 using the provided S3 client.
     *
     * @param filePath the path to the file to be uploaded
     */
    fun multipartUploadWithS3Client(filePath: String?) {
        // Initiate the multipart upload.

        val createMultipartUploadResponse =
            s3Client.createMultipartUpload(Consumer { b: CreateMultipartUploadRequest.Builder? ->
                b!!
                    .bucket(bucketName)
                    .key(key)
            })
        val uploadId = createMultipartUploadResponse.uploadId()

        // Upload the parts of the file.
        var partNumber = 1
        val completedParts: MutableList<CompletedPart?> = ArrayList<CompletedPart?>()
        val bb = ByteBuffer.allocate(1024 * 1024 * 5) // 5 MB byte buffer

        try {
            RandomAccessFile(filePath, "r").use { file ->
                val fileSize = file.length()
                var position: Long = 0
                while (position < fileSize) {
                    file.seek(position)
                    val read = file.getChannel().read(bb).toLong()

                    bb.flip() // Swap position and limit before reading from the buffer.
                    val uploadPartRequest = UploadPartRequest.builder()
                        .bucket(bucketName)
                        .key(key)
                        .uploadId(uploadId)
                        .partNumber(partNumber)
                        .build()

                    val partResponse = s3Client.uploadPart(
                        uploadPartRequest,
                        RequestBody.fromByteBuffer(bb)
                    )

                    val part = CompletedPart.builder()
                        .partNumber(partNumber)
                        .eTag(partResponse.eTag())
                        .build()
                    completedParts.add(part)

                    bb.clear()
                    position += read
                    partNumber++
                }
            }
        } catch (e: IOException) {
            logger.error(e.message)
        }

        // Complete the multipart upload.
        s3Client.completeMultipartUpload(Consumer { b: CompleteMultipartUploadRequest.Builder? ->
            b!!
                .bucket(bucketName)
                .key(key)
                .uploadId(uploadId)
                .multipartUpload(CompletedMultipartUpload.builder().parts(completedParts).build())
        })
    }

    /**
     * Uploads a file to an S3 bucket using the S3AsyncClient and enabling multipart support.
     *
     * @param filePath the local file path of the file to be uploaded
     */
    fun multipartUploadWithS3AsyncClient(filePath: String) {
        // Enable multipart support.
        val s3AsyncClient = S3AsyncClient.builder()
            .multipartEnabled(true)
            .build()

        val response = s3AsyncClient.putObject(
            Consumer { b: PutObjectRequest.Builder? ->
                b!!
                    .bucket(bucketName)
                    .key(key)
            },
            Paths.get(filePath)
        )

        response.join()
        logger.info("File uploaded in multiple 8 MiB parts using S3AsyncClient.")
    }

    // snippet-end:[s3.java2.performMultiPartUpload.s3AsyncClient]
    private fun doMultipartUploadWithS3Client() {
        createBucket()
        try {
            multipartUploadWithS3Client(filePath)
        } catch (e: SdkException) {
            logger.error(e.message)
        } finally {
            deleteResources()
        }
    }

    private fun doMultipartUploadWithS3AsyncClient() {
        createBucket()
        try {
            multipartUploadWithS3AsyncClient(filePath)
        } catch (e: SdkException) {
            logger.error(e.message)
        } finally {
            deleteResources()
        }
    }

    private fun doMultipartUploadWithTransferManager() {
        createBucket()
        try {
            multipartUploadWithTransferManager(filePath)
        } catch (e: SdkException) {
            logger.error(e.message)
        } finally {
            deleteResources()
        }
    }


    companion object {
        val s3Client: S3Client = S3Client.create()
        val bucketName: String = "amzn-s3-demo-bucket" + UUID.randomUUID() // Change bucket name.
        val key: String? = UUID.randomUUID().toString()
        const val classPathFilePath: String = "/multipartUploadFiles/s3-userguide.pdf"
        val filePath: String = getFullFilePath(classPathFilePath)
        private val logger: Logger = LoggerFactory.getLogger(MultiPartUpload::class.java)

        @JvmStatic
        fun main(args: Array<String>) {
            val performMultiPartUpload = MultiPartUpload()
            performMultiPartUpload.doMultipartUploadWithTransferManager()
            performMultiPartUpload.doMultipartUploadWithS3AsyncClient()
            performMultiPartUpload.doMultipartUploadWithS3Client()
        }

        /**
         * Retrieves the full file path of a resource using the given file path.
         *
         * @param filePath the relative file path of the resource
         * @return the full file path of the resource
         * @throws RuntimeException if the file path is invalid or cannot be converted to a URI
         */
        fun getFullFilePath(filePath: String): String {
            val uploadDirectoryURL = MultiPartUpload::class.java.getResource(filePath)
            var fullFilePath: String
            try {
                fullFilePath = Objects.requireNonNull<URL?>(uploadDirectoryURL).toURI().getPath()
            } catch (e: URISyntaxException) {
                throw RuntimeException(e)
            }
            return fullFilePath
        }

        /**
         * Creates an Amazon S3 bucket with the specified bucket name.
         *
         *
         * This method uses the [S3Client] to create a new S3 bucket. It also waits for the
         * bucket to be successfully created using the [software.amazon.awssdk.services.s3.waiters.S3Waiter].
         *
         *
         * @throws software.amazon.awssdk.services.s3.model.S3Exception if there is an error creating the bucket
         */
        fun createBucket() {
            s3Client.createBucket(Consumer { b: CreateBucketRequest.Builder? ->
                b!!.bucket(
                    bucketName
                )
            })
            s3Client.waiter().use { s3Waiter ->
                s3Waiter.waitUntilBucketExists(Consumer { b: HeadBucketRequest.Builder? ->
                    b!!.bucket(
                        bucketName
                    )
                })
            }
        }

        /**
         * Deletes the resources stored in the specified S3 bucket.
         *
         *
         * This method first deletes the object with the specified key from the S3 bucket,
         * and then deletes the S3 bucket itself.
         *
         * @throws RuntimeException if there is an error deleting the resources
         */
        fun deleteResources() {
            s3Client.deleteObject(Consumer { b: DeleteObjectRequest.Builder? ->
                b!!.bucket(
                    bucketName
                ).key(key)
            })
            s3Client.deleteBucket(Consumer { b: DeleteBucketRequest.Builder? ->
                b!!.bucket(
                    bucketName
                )
            })
        }
    }
} // snippet-end:[s3.java2.performMultiPartUpload.full]
