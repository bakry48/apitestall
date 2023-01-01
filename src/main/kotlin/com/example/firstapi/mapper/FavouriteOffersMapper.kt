package com.example.firstapi.mapper

import com.example.firstapi.models.dto.FavouriteOffersDto
import com.example.firstapi.models.entity.FavouriteOffers
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
abstract class FavouriteOffersMapper {

    @Mappings(
        Mapping(source = "offerId" , target = "offer.id"),
        Mapping(target = "nationalId" , constant = "2845212554558")
    )
    abstract fun toFavouriteOffersEntity(favouriteOffersDto: FavouriteOffersDto) : FavouriteOffers


}