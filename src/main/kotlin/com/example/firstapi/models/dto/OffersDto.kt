package com.example.firstapi.models.dto

import java.io.Serializable

/**
 * A DTO for the {@link com.example.firstapi.models.entity.Offer} entity
 */
data class OffersDto(
    var offerNameEn: String? = null,
    var offerNameAr: String? = null,
    var titleAr: String? = null,
    var titleEn: String? = null
) : Serializable