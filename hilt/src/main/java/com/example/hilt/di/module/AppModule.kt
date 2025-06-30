package com.example.hilt.di.module

import android.app.Activity
import android.app.Application
import android.content.Context
import com.example.hilt.bean.User
import com.example.hilt.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class AppModule {

    @Provides
    @ActivityScoped
    fun provideUser(): User {
        return User("provideUser")
    }

    // 需要去掉MainViewModel上的@Inject、@ActivityContext注解
    @Provides
    fun provideMainViewModel(
        user: User,
        application: Application,
        // SingletonComponent 不能提供 Activity
        activity: Activity,
        // @ApplicationContext context: Context
        @ActivityContext context: Context
    ): MainViewModel {
        return MainViewModel(user, application, activity, context)
    }
}