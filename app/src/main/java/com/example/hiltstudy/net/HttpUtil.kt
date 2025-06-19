package com.example.hiltstudy.net

import android.content.Context
import android.util.Log
private const val TAG = "HttpUtil"

class HttpUtil(
    private val httpClient: HttpClient,
    private val context: Context
) {
    fun introduce() {
        Log.d(TAG, "introduce: HttpUtil=$this, " +
            "httpClient=$httpClient, " +
            "context=$context")
    }
}