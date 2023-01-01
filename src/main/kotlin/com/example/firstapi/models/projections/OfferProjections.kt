package com.example.firstapi.models.projections

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.beans.factory.annotation.Value

@JsonInclude(JsonInclude.Include.NON_NULL)
interface OfferProjections {

    fun getOfferNameAr():String
    fun getId():Long
    val titleAr : String?

    fun getStatus():String
}