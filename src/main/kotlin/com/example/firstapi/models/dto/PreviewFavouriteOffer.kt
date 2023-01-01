package com.example.firstapi.models.dto

import com.example.firstapi.models.entity.Offer
import java.io.Serializable

data class PreviewFavouriteOffer (
    var nationalId:String? = null,
    var offer : OffersDto? = null

) : Serializable