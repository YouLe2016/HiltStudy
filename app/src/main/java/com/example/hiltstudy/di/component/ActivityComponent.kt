package com.example.hiltstudy.di.component

import com.example.hiltstudy.MainActivity
import com.example.hiltstudy.MainActivity2
import com.example.hiltstudy.di.anno.ActivityScope
import dagger.Component

@Component(
    dependencies = [AppComponent::class]
)
@ActivityScope
interface ActivityComponent {
    fun inject(activity: MainActivity)
}