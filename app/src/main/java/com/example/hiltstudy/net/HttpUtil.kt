package com.example.hiltstudy.net

import android.util.Log

private const val TAG = "HttpUtil"

class HttpUtil(
    private val httpClient: HttpClient,
) {
    fun introduce() {
        Log.d(TAG, "introduce: HttpUtil=$this, httpClient=$httpClient")
    }
}