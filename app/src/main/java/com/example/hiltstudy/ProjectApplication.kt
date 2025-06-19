package com.example.hiltstudy

import android.app.Application
import com.example.hiltstudy.di.component.AppComponent
import com.example.hiltstudy.di.component.DaggerAppComponent
import com.example.hiltstudy.di.module.ProjectModule

// 如果没有这个，实现不了在不同的Activity中单例效果
lateinit var ProjectAppComponent: AppComponent
lateinit var ProjectApplicationInstance: ProjectApplication

class ProjectApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ProjectApplicationInstance = this
        // 使用projectModule方法，将Application注入到IOC容器中
        ProjectAppComponent = DaggerAppComponent.builder()
            .projectModule(ProjectModule(this))
            .build()
    }
}