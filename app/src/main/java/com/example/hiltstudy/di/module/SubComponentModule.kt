package com.example.hiltstudy.di.module

import com.example.hiltstudy.di.component.Activity2Component
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck

@Module(
    subcomponents = [
        Activity2Component::class
    ]
)
@DisableInstallInCheck
class SubComponentModule