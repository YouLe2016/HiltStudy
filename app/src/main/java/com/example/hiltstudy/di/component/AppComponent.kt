package com.example.hiltstudy.di.component

import com.example.hiltstudy.MainActivity
import com.example.hiltstudy.MainActivity2
import com.example.hiltstudy.di.module.NetModule
import com.example.hiltstudy.di.module.ProjectModule
import dagger.Component
import javax.inject.Singleton

/**
 * 理解为一个IOC容器
 */
@Component(
    modules = [NetModule::class, ProjectModule::class]
)
@Singleton
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: MainActivity2)
}