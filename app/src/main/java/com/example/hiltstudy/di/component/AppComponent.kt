package com.example.hiltstudy.di.component

import com.example.hiltstudy.di.module.NetModule
import com.example.hiltstudy.di.module.ProjectModule
import com.example.hiltstudy.di.module.SubComponentModule
import com.example.hiltstudy.net.HttpUtil
import dagger.Component
import javax.inject.Singleton

/**
 * 理解为一个IOC容器
 */
@Component(
    modules = [
        NetModule::class, ProjectModule::class, SubComponentModule::class
    ]
)
@Singleton
interface AppComponent {
    fun findHttpUtil(): HttpUtil

    fun createActivity2ComponentFactory(): Activity2Component.Factory
}