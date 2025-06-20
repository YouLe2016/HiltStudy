package com.example.hiltstudy

import android.app.Application
import android.util.Log
import com.example.hiltstudy.di.creator.AppComponentCreator

lateinit var ProjectApplicationInstance: ProjectApplication

private const val TAG = "ProjectApplication"

class ProjectApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ProjectApplicationInstance = this
        Log.d(TAG, "onCreate: ProjectApplicationInstance=$ProjectApplicationInstance")
        AppComponentCreator.create(this)
    }
}