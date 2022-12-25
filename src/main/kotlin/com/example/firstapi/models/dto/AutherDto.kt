package com.example.firstapi.models.dto

import java.io.Serializable
import java.net.Inet4Address

/**
 * A DTO for the {@link com.example.firstapi.models.entity.Auther} entity
 */
data class AutherDto(val id: Long? = null, val name: String? = null, val nationalId: String? = null  , val ipAddress: String = Inet4Address.getLocalHost().hostAddress , val email: String? = null) : Serializable