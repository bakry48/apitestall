package com.example.firstapi.util

import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Response<T>(
    val status: ResponseStatus? = null,
    val message: String? = null,
    val data: T? = null,

) {
    fun success(): Boolean {
        return Objects.nonNull(status) && status == ResponseStatus.SUCCESS
    }

    fun hasData(): Boolean {
        return Objects.nonNull(data)
    }
}