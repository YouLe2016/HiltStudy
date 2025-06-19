package com.example.hiltstudy.di

import com.example.hiltstudy.MainActivity
import com.example.hiltstudy.MainActivity2
import dagger.Component
import javax.inject.Singleton

/**
 * 理解为一个IOC容器
 */
@Component(
    modules = [NetModule::class]
)
@Singleton
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: MainActivity2)
}