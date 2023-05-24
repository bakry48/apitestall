package com.example.firstapi.models.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class MerchantCategoryDsquareall (
    @JsonProperty("\$id")
    val id: String,
    @JsonProperty("CategoryId")
    val categoryId: Int,
    @JsonProperty("Title")
    val title: String,
    @JsonProperty("Image")
    val image: String

)