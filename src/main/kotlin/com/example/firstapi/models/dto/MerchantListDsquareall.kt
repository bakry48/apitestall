package com.example.firstapi.models.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal
import javax.print.attribute.IntegerSyntax

data class MerchantListDsquareall (
    @JsonProperty("\$id")
    val id: String,
    @JsonProperty("merchantName")
    val merchantName: String,
    @JsonProperty("merchantDescription")
    val merchantDescription: String?,
    @JsonProperty("categoryId")
    val categoryId: Long?,
    @JsonProperty("merchantImage")
    val merchantImage: String?,
    @JsonProperty("branches")
    val branches: List<Branch>?=null
)

data class Branch(
    @JsonProperty("\$id")
    val id: String,
    @JsonProperty("Latitude")
    val latitude: String?,
    @JsonProperty("Longitude")
    val longitude: String?,
    @JsonProperty("BranchTitle")
    val branchTitle: String,
    @JsonProperty("BranchAddress")
    val branchAddress: String
)