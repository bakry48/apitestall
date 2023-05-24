package com.example.firstapi.models.dto

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class MerchantsLogo (
    var id : Int? = null ,
    var merchantsNameAr : String?=null ,
    var merchantsNameEn : String?=null ,
    var logoUrl: String?=null,
    var merchants : String? = null
)