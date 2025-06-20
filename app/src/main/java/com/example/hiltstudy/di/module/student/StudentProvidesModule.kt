package com.example.hiltstudy.di.module.student

import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Named

@Module
@DisableInstallInCheck
object StudentProvidesModule {
    @Provides
    @Named("String_China1")
    fun provideChinaStudentName(): String {
        return "ChinaStudent"
    }

    @Provides
    @Named("String_China2")
    fun provideChinaStudentName2(): String {
        return "ChinaStudent2"
    }
}