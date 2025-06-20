package com.example.hiltstudy.di.component

import com.example.hiltstudy.MainActivity2
import com.example.hiltstudy.di.anno.ActivityScope
import dagger.Subcomponent

@Subcomponent
@ActivityScope
interface Activity2Component {
    fun inject(activity: MainActivity2)

    @Subcomponent.Factory
    interface Factory {
        fun create(): Activity2Component
    }
}

