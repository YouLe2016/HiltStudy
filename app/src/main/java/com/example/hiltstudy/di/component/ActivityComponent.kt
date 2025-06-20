package com.example.hiltstudy.di.component

import com.example.hiltstudy.MainActivity
import com.example.hiltstudy.MainActivity2
import com.example.hiltstudy.di.anno.MyScope
import dagger.Component

@Component(
    dependencies = [AppComponent::class]
)
@MyScope
interface ActivityComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: MainActivity2)
}