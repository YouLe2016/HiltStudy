package com.example.hiltstudy.di.module.student

import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck

@Module(
    includes = [
        StudentBindsModule::class,
        StudentProvidesModule::class
    ]
)
@DisableInstallInCheck
object StudentModule