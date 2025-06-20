package com.example.hiltstudy.di.module

import com.example.hiltstudy.di.bean.student.AmericanStudent
import com.example.hiltstudy.di.bean.student.Student
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck

@Module
@DisableInstallInCheck
abstract class StudentModule {
    @Binds
    abstract fun bindStudent(student: AmericanStudent): Student
}