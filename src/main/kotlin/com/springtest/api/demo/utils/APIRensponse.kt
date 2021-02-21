package com.springtest.api.demo.utils

import org.springframework.http.HttpStatus

data class APIRensponse<T>(
        val code: Int,
        val status: HttpStatus,
        val data: T
)
