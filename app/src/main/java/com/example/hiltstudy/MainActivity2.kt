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
import androidx.compose.ui.Modifier
import com.example.hiltstudy.di.User
import com.example.hiltstudy.net.HttpUtil
import com.example.hiltstudy.ui.theme.HiltStudyTheme
import javax.inject.Inject

private const val TAG = "MainActivity2"

class MainActivity2 : ComponentActivity() {
    @Inject
    lateinit var httpUtil: HttpUtil
//    @Inject
//    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        ProjectAppComponent.inject(this)
        Log.d(TAG, "onCreate: httpUtil=$httpUtil")
//        Log.d(TAG, "onCreate: user=$user")

        setContent {
            HiltStudyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Text(
                        "MainActivity2",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
