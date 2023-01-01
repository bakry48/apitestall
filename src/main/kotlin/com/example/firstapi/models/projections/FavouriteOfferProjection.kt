package com.example.firstapi.models.projections

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.beans.factory.annotation.Value

interface FavouriteOfferProjection {

    val nationalId:String?
    val offer : OfferProjections?

    @Value("#{target.offer.status}")
    fun getStatus():String
}