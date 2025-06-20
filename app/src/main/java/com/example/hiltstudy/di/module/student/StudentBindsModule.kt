package com.example.hiltstudy.di.module.student

import com.example.hiltstudy.di.bean.student.AmericanStudent
import com.example.hiltstudy.di.bean.student.ChinaStudent
import com.example.hiltstudy.di.bean.student.Student
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Named

@Module
@DisableInstallInCheck
interface StudentBindsModule {
    @Binds
    @Named("American")
    fun bindAmericanStudent(student: AmericanStudent): Student

    @Binds
    @Named("China")
    fun bindChinaStudent(student: ChinaStudent): Student
}