package com.example.hiltstudy.di.creator

import com.example.hiltstudy.di.component.ActivityComponent
import com.example.hiltstudy.di.component.DaggerActivityComponent

object ActivityComponentCreator {
    fun create(): ActivityComponent {
        return DaggerActivityComponent.builder()
            .appComponent(AppComponentCreator.ProjectAppComponent)
            .build()
    }
}