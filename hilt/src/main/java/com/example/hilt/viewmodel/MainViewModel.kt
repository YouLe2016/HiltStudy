package com.example.hilt.viewmodel

import android.app.Activity
import android.app.Application
import android.content.Context
import android.util.Log
import com.example.hilt.bean.User
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

private const val TAG = "MainViewModel"

// 已经绑定的类
 class MainViewModel @Inject constructor(
    private val user: User,
    private val application: Application,
    private val activity: Activity,
    @ActivityContext private val context: Context
) {
    fun introduction() {
        Log.i(TAG, "introduction: user = $user, application = $application")
        Log.i(TAG, "introduction: activity = $activity")
        Log.i(TAG, "introduction: context = $context")
    }
}