package com.example.hiltstudy

import android.content.Context
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
import com.example.hiltstudy.di.bean.User
import com.example.hiltstudy.di.creator.AppComponentCreator
import com.example.hiltstudy.net.HttpUtil
import com.example.hiltstudy.ui.theme.HiltStudyTheme
import javax.inject.Inject
import javax.inject.Named

private const val TAG = "MainActivity2"

class MainActivity2 : ComponentActivity() {
    @Inject
    @Named("User")
    lateinit var user: User
    @Inject
    lateinit var httpUtil: HttpUtil

    @Inject
    @Named("UserWithName")
    lateinit var user2: User
    @Inject
    lateinit var httpUtil2: HttpUtil

    @Inject
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        AppComponentCreator.ProjectAppComponent
            .createActivity2ComponentFactory()
            .create()
            .inject(this)

        Log.d(TAG, "onCreate: MainActivity2=$this")
        Log.d(TAG, "onCreate: user=$user")
        Log.d(TAG, "onCreate: user2=$user2")
        Log.d(TAG, "onCreate: user是否是单例=${user == user2}")
        Log.d(TAG, "onCreate: httpUtil: $httpUtil")
        Log.d(TAG, "onCreate: httpUtil是否是单例=${httpUtil == httpUtil2}")

        Log.d(TAG, "onCreate: context=${context}")
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
