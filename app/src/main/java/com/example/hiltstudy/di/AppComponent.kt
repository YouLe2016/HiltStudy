package com.example.hiltstudy.di

import com.example.hiltstudy.MainActivity
import dagger.Component

/**
 * 理解为一个IOC容器
 */
@Component(
    modules = [NetModule::class]
)
interface AppComponent {
    fun inject(activity: MainActivity)
}