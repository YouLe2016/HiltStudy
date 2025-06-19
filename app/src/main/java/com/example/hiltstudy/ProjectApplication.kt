package com.example.hiltstudy

import android.app.Application
import com.example.hiltstudy.di.AppComponent
import com.example.hiltstudy.di.DaggerAppComponent

// 如果没有这个，实现不了在不同的Activity中单例效果
lateinit var ProjectAppComponent: AppComponent

class ProjectApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ProjectAppComponent = DaggerAppComponent.create()
    }
}