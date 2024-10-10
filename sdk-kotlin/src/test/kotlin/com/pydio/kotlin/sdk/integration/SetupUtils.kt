package com.pydio.kotlin.sdk.integration

import com.pydio.kotlin.sdk.utils.tests.RemoteServerConfig
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.file.Files
import java.nio.file.Path
import java.util.Properties
import kotlin.io.path.listDirectoryEntries

class SetupUtils {

    fun loadConfigs(): Map<String, RemoteServerConfig> {
        val classLoader = Thread.currentThread().contextClassLoader
        val foundConfigs: MutableMap<String, RemoteServerConfig> = HashMap()

        val resourcePath = "targets" // Directory in resources
        val uri = classLoader.getResource(resourcePath)?.toURI()
        check(uri != null)
        val dir = Path.of(uri)

        dir.listDirectoryEntries()
            .filter { Files.isRegularFile(it) && it.toString().endsWith(".properties") }
            .forEach { path ->
                println("Loading $path")
                classLoader.getResourceAsStream("$resourcePath/${path.fileName}")
                    ?.use { inputStream ->
                        loadOne(inputStream)?.let {
                            if (!it.skipServer) {
                                foundConfigs[it.stateID.id] = it
                            }
                        }
                    }
            }

        val inputStream: InputStream? = classLoader.getResourceAsStream("localhost.properties")
        check(inputStream != null)
        loadOne(inputStream)?.let {
            if (!it.skipServer) {
                foundConfigs[it.stateID.id] = it
            }
        }

        return foundConfigs
    }

    // Helpers
    private fun loadOne(ios: InputStream): RemoteServerConfig? {
        val prop: Properties = Properties()
        prop.load(InputStreamReader(ios))

        val currConf: RemoteServerConfig = RemoteServerConfig(
            skipServer = "true" == prop.getProperty("skipServer"),
            urlString = prop.getProperty("urlString"),
            skipVerify = "true" == prop.getProperty("skipVerify"),
            username = prop.getProperty("username"),
            isAdmin = "true" == prop.getProperty("isAdmin"),
            pwd = prop.getProperty("pwd"),
            pat = prop.getProperty("pat"),
            defaultWS = prop.getProperty("defaultWorkspace"),
        )
        return currConf
    }
}
