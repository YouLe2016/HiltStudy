package com.example.hiltstudy.di.module

import com.example.hiltstudy.di.bean.student.AmericanStudent
import com.example.hiltstudy.di.bean.student.ChinaStudent
import com.example.hiltstudy.di.bean.student.Student
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Named

@Module
@DisableInstallInCheck
abstract class StudentModule {
    @Binds
    @Named("American")
    abstract fun bindAmericanStudent(student: AmericanStudent): Student

    @Binds
    @Named("China")
    abstract fun bindChinaStudent(student: ChinaStudent): Student
}