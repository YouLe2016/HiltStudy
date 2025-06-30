package com.example.hilt.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.hilt.bean.User
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

private const val TAG = "Main2ViewModel"

@HiltViewModel
class Main2ViewModel @Inject constructor(
    private val user: User,
    private val application: Application,
    @ApplicationContext private val context: Context
) : ViewModel() {
    fun introduction() {
        Log.i(TAG, "introduction: user = $user, application = $application")
        Log.i(TAG, "introduction: context = $context")
    }
}