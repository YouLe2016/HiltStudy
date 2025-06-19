package com.example.hiltstudy

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hiltstudy.di.DaggerAppComponent
import com.example.hiltstudy.di.User
import com.example.hiltstudy.ui.theme.HiltStudyTheme
import javax.inject.Inject

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    @Inject
    // 不能加private, 也就意味着使用set方法注入的成员变量
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerAppComponent.create().inject(this)
        Log.d(TAG, "onCreate: user=$user")

        enableEdgeToEdge()
        setContent {
            HiltStudyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = user.toString(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HiltStudyTheme {
        Greeting("Android")
    }
}