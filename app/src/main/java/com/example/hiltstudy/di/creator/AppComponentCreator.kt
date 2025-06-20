package com.example.hiltstudy.di.creator

import com.example.hiltstudy.ProjectApplication
import com.example.hiltstudy.di.component.AppComponent
import com.example.hiltstudy.di.component.DaggerAppComponent
import com.example.hiltstudy.di.module.ProjectModule

object AppComponentCreator {
    // 如果没有这个，实现不了在不同的Activity中单例效果
    lateinit var ProjectAppComponent: AppComponent

    fun create(application: ProjectApplication) {
        // 使用projectModule方法，将Application注入到IOC容器中
        ProjectAppComponent = DaggerAppComponent.builder()
            .projectModule(ProjectModule(application))
            .build()
    }
}