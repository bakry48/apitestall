package com.example.firstapi.mapper

import com.example.firstapi.models.dto.OffersDto
import com.example.firstapi.models.entity.Offer
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
abstract class OffersMapper {

    abstract fun toEntity(offersDto: OffersDto): Offer

    abstract fun toDto(offer: Offer): OffersDto


}