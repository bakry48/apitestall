package com.example.firstapi.models.dto

import java.io.Serializable

data class MerchantCategoriesDto (
    var categoryId:Int?=null,
    var categoryName:String?=null,
    var merchantsList : List<MerchantsLogoch>? = null
): Serializable