package com.example.firstapi.mapper

import com.example.firstapi.models.dto.OfferDto
import com.example.firstapi.models.entity.Offer
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
abstract class OfferMapper {
    abstract  fun toOfferEntity(offerDto: OfferDto) : Offer

   // abstract fun toOfferDto( offerEntity: MutableList<Offer>) : MutableList<OfferDto>
}