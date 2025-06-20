package com.example.hiltstudy.di.component

import com.example.hiltstudy.MainActivity
import com.example.hiltstudy.di.anno.ActivityScope
import com.example.hiltstudy.di.module.student.StudentModule
import com.example.hiltstudy.di.module.UserModule
import dagger.Component

@Component(
    dependencies = [AppComponent::class],
    modules = [
        StudentModule::class, UserModule::class
    ]
)
@ActivityScope
interface ActivityComponent {
    fun inject(activity: MainActivity)
}