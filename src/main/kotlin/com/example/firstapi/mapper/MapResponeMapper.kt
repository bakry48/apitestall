package com.example.firstapi.mapper

import com.example.firstapi.models.dto.AutherDto
import com.example.firstapi.models.dto.FavouriteOffersDto
import com.example.firstapi.models.dto.OffersDto
import com.example.firstapi.models.dto.PreviewFavouriteOffer
import com.example.firstapi.models.entity.Auther
import com.example.firstapi.models.entity.FavouriteOffers
import com.example.firstapi.models.entity.Offer

class MapResponeMapper {

    companion object{
        private fun Offer.mapOffersDto(): OffersDto = OffersDto().apply {
            offerNameEn = this@mapOffersDto.offerNameEn
            offerNameAr = this@mapOffersDto.offerNameAr
            titleAr = this@mapOffersDto.titleAr
            titleEn = this@mapOffersDto.titleEn
        }

        fun List<Offer>.mapOffer():List<OffersDto> = this.map{it.mapOffersDto()}.toList()

        private fun FavouriteOffers.mapFavouriteOfferDto(): PreviewFavouriteOffer = PreviewFavouriteOffer().apply {
           nationalId=this@mapFavouriteOfferDto.nationalId
            offer = this@mapFavouriteOfferDto.offer?.mapOffersDto()
        }

        fun List<FavouriteOffers>.mapFavouriteOffer(): List<PreviewFavouriteOffer> = this.map { it.mapFavouriteOfferDto() }.toList()
    }
}