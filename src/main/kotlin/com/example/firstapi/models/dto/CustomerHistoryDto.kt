package com.example.firstapi.models.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class CustomerHistoryDto(
    @JsonProperty("\$id")
    val id: String?,
    @JsonProperty("SettlementAmount")
    val settlementAmount: Double?,
    @JsonProperty("TotalCount")
    val totalCount: Int?,
    @JsonProperty("VoucherDetails")
    val voucherDetails: List<VoucherDetails>?,
    @JsonProperty("EnglishErrorMessage")
    val englishErrormessage: String?,
    @JsonProperty("ArabicErrorMessage")
    val arabicErrormessage: String?,
)
data class VoucherDetails(
    @JsonProperty("\$id")
    val id: String?,
    @JsonProperty("TransactionID")
    val transactionId: Long?,
    @JsonProperty("Amount")
    val amount: Double?,
    @JsonProperty("BurnDate")
    val burnDate: String?,
    @JsonProperty("ExpiryDate")
    val expiryDate: String?,
    @JsonProperty("VoucherNumber")
    val voucherNumber: String?,
    @JsonProperty("Status")
    val status: String?,
    @JsonProperty("OfferName")
    val offerName: String?,
    @JsonProperty("BranchName")
    val branchName: String?,
    @JsonProperty("Discount")
    val discount: Double?,
    @JsonProperty("SubscriptionDate")
    val subscriptionDate: String?,
    @JsonProperty("RemainingUsage")
    val remainingUsage: Int?,
    @JsonProperty("LastModifiedAction")
    val lastModifiedAction: String?,
    @JsonProperty("OfferTitle")
    val offerTitle: String?,
    @JsonProperty("OfferNumber")
    val offerNumber: String?,
    @JsonProperty("OfferDescription")
    val offerDescription: String?,
    @JsonProperty("MerchantImage")
    val merchantImage: String?,
    @JsonProperty("MerchantCategory")
    val merchantCategory: String?,
    @JsonProperty("Actor")
    val actor: String?,
    @JsonProperty("OfferImage")
    val offerImage: String?,
    @JsonProperty("TermsAndCondition")
    val termsAndCondition: String?,
)
