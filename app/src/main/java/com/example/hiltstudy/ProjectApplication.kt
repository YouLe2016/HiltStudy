package com.example.hiltstudy

import android.app.Application
import com.example.hiltstudy.di.creator.AppComponentCreator

lateinit var ProjectApplicationInstance: ProjectApplication

class ProjectApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ProjectApplicationInstance = this
        AppComponentCreator.create(this)
    }
}