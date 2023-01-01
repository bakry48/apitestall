package com.example.firstapi.exception

import com.example.firstapi.util.ErrorCode
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import javax.servlet.http.HttpServletRequest

class ErrorDetails(val errorCode: ErrorCode, var customMessage: String? = null) {
//    fun getLocaleFromContext(): String {
//        val curRequest: HttpServletRequest = (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes).request
//        return curRequest.getHeader("X-Locale") ?: Language.en.name
//    }
//    fun getLocaleForUser(): String {
//        return getLocaleFromContext()
//    }
//    fun localizedMessage(): String {
//        return customMessage ?: ErrorCode.msgFromCode(errorCode.code, getLocaleForUser())
//    }
}