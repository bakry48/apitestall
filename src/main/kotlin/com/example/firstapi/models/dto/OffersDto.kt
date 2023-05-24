package com.example.firstapi.models.dto

import com.example.firstapi.models.entity.FavouriteOffers
import com.fasterxml.jackson.annotation.JsonInclude
import java.io.Serializable

/**
 * A DTO for the {@link com.example.firstapi.models.entity.Offer} entity
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class OffersDto(
    var isFav: String?=null,
    var offerNameEn: String? = null,
    var offerNameAr: String? = null,
    var titleAr: String? = null,
    var titleEn: String? = null,
    var statuse: String?=null,
    var isOfferFavourite : Boolean?= false,
    var expireDate : String?=null

) : Serializable