package com.example.firstapi.models.vo

import com.fasterxml.jackson.annotation.JsonInclude
import java.math.BigDecimal

@JsonInclude(JsonInclude.Include.NON_NULL)
data class DSquareVoucherVo (
    val totalCount: Int?=0,
    val name: String?,
    val status:String?,
    val amount: Double?,
    val points: Double?,
    val expiryDate: String?,
    val voucherNumber: String? = null,
    val imageUrl:String?
)
