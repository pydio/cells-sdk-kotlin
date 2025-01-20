package com.pydio.kotlin.android.testawssdk

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.pydio.kotlin.android.testawssdk.ui.theme.TestAWSSDKTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestAWSSDKTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Wire Cells",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    val scope = rememberCoroutineScope()
    val ctx = LocalContext.current

    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )

        Button(
            onClick = {
                scope.launch {
                    val res = withContext(Dispatchers.IO) {
                        com.pydio.kotlin.sdk.sandbox.pingServer()
                    }

                    val msg = if (res == 200) {
                        "Server can be accessed"
                    } else "cannot reach server - error $res"

                    Toast
                        .makeText(ctx, msg, Toast.LENGTH_LONG)
                        .show()
                }
            },
            modifier = modifier
        ) {
            Text(text = "Ping Server")
        }

        Button(
            onClick = {
                scope.launch {
                    withContext(Dispatchers.IO) {
                        com.pydio.kotlin.sdk.sandbox.putS3Object("common-files/test-from-android.txt")
                    }

                    Toast
                        .makeText(ctx, "File has been created", Toast.LENGTH_LONG)
                        .show()
                }
            },
            modifier = modifier
        ) {
            Text(text = "Create File")
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestAWSSDKTheme {
        Greeting("Android")
    }
}
