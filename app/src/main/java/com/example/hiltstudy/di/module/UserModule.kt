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
    fun provideUserWithName(@Named("custom") name: String): User {
        return User(name = name)
    }

    @Provides
    @Named("custom")
    fun provideName(): String {
        return "自定义名字"
    }

    @Provides
    @Named("libai")
    fun provideLiBaiName(): String {
        return "李白"
    }
}