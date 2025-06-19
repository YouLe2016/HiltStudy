package com.example.hiltstudy

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.hiltstudy.di.User
import com.example.hiltstudy.di.component.DaggerActivityComponent
import com.example.hiltstudy.net.HttpUtil
import com.example.hiltstudy.ui.theme.HiltStudyTheme
import javax.inject.Inject

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    @Inject
    // 不能加private, 也就意味着使用set方法注入的成员变量
    lateinit var user: User
//    @Inject
//    lateinit var httpUtil: HttpUtil

    @Inject
    lateinit var user2: User
//    @Inject
//    lateinit var httpUtil2: HttpUtil

//    @Inject
//    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ProjectAppComponent.inject(this)
        DaggerActivityComponent.create().inject(this)

        Log.d(TAG, "onCreate: application=${this.application}")
        // 旋转屏幕时，下面三个都是新的对象
        Log.d(TAG, "onCreate: MainActivity=$this")
        Log.d(TAG, "onCreate: user=$user")
//        Log.d(TAG, "onCreate: httpUtil: $httpUtil")
//        httpUtil.introduce()
//        Log.d(TAG, "onCreate: httpUtil2: $httpUtil2")
        Log.d(TAG, "onCreate: user是否是单例=${user == user2}")
//        Log.d(TAG, "onCreate: httpUtil是否是单例=${httpUtil == httpUtil2}")

        // 以下都是同一对象
        Log.d(TAG, "onCreate: -------------application--------------")
        Log.d(TAG, "onCreate: ProjectApplicationInstance=${ProjectApplicationInstance}")
        Log.d(TAG, "onCreate: applicationContext=${ProjectApplicationInstance.applicationContext}")
//        Log.d(TAG, "onCreate: context=${this.context}")
        Log.d(TAG, "onCreate: applicationContext=${this.applicationContext}")
        Log.d(TAG, "onCreate: -------------application  end--------------")

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
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Button(onClick = {
            context.startActivity(Intent(context, MainActivity2::class.java))
        }){
            Text("跳转页面")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HiltStudyTheme {
        Greeting("Android")
    }
}