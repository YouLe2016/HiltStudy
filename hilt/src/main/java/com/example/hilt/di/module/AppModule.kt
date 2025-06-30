package com.example.hilt.di.module

import android.content.Context
import com.example.hilt.bean.User
import com.example.hilt.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
class AppModule {

    @Provides
    @ActivityRetainedScoped
    fun provideUser(): User {
        return User("provideUser")
    }

    // 需要去掉MainViewModel上的@Inject、@ActivityContext注解
//    @Provides
//    fun provideMainViewModel(
//        user: User,
//        application: Application,
//        // SingletonComponent 不能提供 Activity
//        activity: Activity,
//        // @ApplicationContext context: Context
//        @ActivityContext context: Context
//    ): MainViewModel {
//        return MainViewModel(user, application, activity, context)
//    }
}