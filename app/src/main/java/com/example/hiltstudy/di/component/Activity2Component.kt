package com.example.hiltstudy.di.component

import com.example.hiltstudy.MainActivity2
import com.example.hiltstudy.di.anno.ActivityScope
import com.example.hiltstudy.di.module.UserModule
import dagger.Subcomponent

@Subcomponent(
    modules = [
        UserModule::class
    ]
)
@ActivityScope
interface Activity2Component {
    fun inject(activity: MainActivity2)

    @Subcomponent.Factory
    interface Factory {
        fun create(): Activity2Component
    }
}

