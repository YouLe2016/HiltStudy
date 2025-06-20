package com.example.hiltstudy.di.bean.student

import javax.inject.Inject
import javax.inject.Named

data class ChinaStudent @Inject constructor(
    @Named("String_China2")
    private val name: String
): Student