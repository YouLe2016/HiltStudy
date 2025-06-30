package com.example.hilt.di.module

import android.app.Activity
import android.app.Application
import com.example.hilt.bean.User
import com.example.hilt.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import androidx.activity.ComponentActivity
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
class AppModule {

    @Provides
    @ActivityScoped
    fun provideUser(): User {
        return User("provideUser")
    }

    @Provides
    fun provideMainViewModel(
        user: User,
        application: Application,
        // SingletonComponent 不能提供 Activity
        activity: Activity
    ): MainViewModel {
        return MainViewModel(user, application, activity)
    }
}