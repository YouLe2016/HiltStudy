package com.example.hilt.bean

import javax.inject.Inject

class User(
    val name: String
) {
//    @Inject
    constructor() : this("user")
}
