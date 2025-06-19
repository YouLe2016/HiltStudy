package com.example.hiltstudy.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Singleton

@Module
@DisableInstallInCheck
class ProjectModule(
    private val application: Application
) {
    @Singleton
    @Provides
    fun providerContext(): Context {
        return application.applicationContext
    }
}