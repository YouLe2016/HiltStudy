package com.example.hiltstudy.di.module

import com.example.hiltstudy.di.anno.ActivityScope
import com.example.hiltstudy.di.bean.User
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Named

@Module
@DisableInstallInCheck
class UserModule {
    @Provides
    @ActivityScope
    @Named("User")
    fun provideUser(): User {
        return User()
    }

    @Provides
    @ActivityScope
    @Named("UserWithName")
    fun provideUserWithName(): User {
        return User(name = "自定义名字")
    }
}