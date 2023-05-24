package com.example.firstapi.models.dto

import java.io.Serializable
import java.time.LocalDate

/**
 * A DTO for the {@link com.example.firstapi.models.entity.Offer} entity
 */
data class OfferDto(
    val offerNameEn: String? = null,
    var offerNameAr: String? = null,
    val titleAr: String? = null,
    val titleEn: String? = null,
    val subtitleAr: String? = null,
    val subtitleEn: String? = null,
    val descriptionAr: String? = "",
    val descriptionEn: String? = "",
    val startDate: LocalDate? = null,
    val expiryDate: String? = null,
    val webLink: String? = "",
    val shopOnline: Boolean = false,
    val live: Boolean = false,
    val pinOrder: Int = 0,
    val storeLocation: String? = "",
    val hasStoreLocation: Boolean = false,
    val defaultTemplate: Boolean? = false
): Serializable