package com.example.firstapi.mapper


import com.example.firstapi.models.dto.OffersDto
import com.example.firstapi.models.dto.PreviewFavouriteOffer
import com.example.firstapi.models.entity.FavouriteOffers
import com.example.firstapi.models.entity.Offer

class MapResponeMapper {

    companion object{
        // flag fav mapper have favourite list parameter to pass list to mapper
        fun List<Offer>.mapPublishedOffer(favouriteOffer : List<FavouriteOffers>?) : List<OffersDto> = this.map {it.mapPublishedOffersDto(favouriteOffer)}.toList()

        // mapper to check if id found in list or not to pass value true or false
        private fun Offer.mapPublishedOffersDto(favouriteOffer: List<FavouriteOffers>? = null):OffersDto = OffersDto().apply {
            offerNameAr = this@mapPublishedOffersDto.offerNameAr
            offerNameEn = this@mapPublishedOffersDto.offerNameEn

            // flag use any to check if id fount in this list or not
            isOfferFavourite = favouriteOffer?.any { it.offer?.id == this@mapPublishedOffersDto.id }

        }



        private fun Offer.mapOffersDto(): OffersDto = OffersDto().apply {
            offerNameEn = this@mapOffersDto.offerNameEn
            offerNameAr = this@mapOffersDto.offerNameAr
            titleAr = this@mapOffersDto.titleAr
            titleEn = this@mapOffersDto.titleEn
            statuse = this@mapOffersDto.status.toString()
            isFav = this@mapOffersDto.status.toString()

        }

        fun List<Offer>.mapOffer():List<OffersDto> = this.map{it.mapOffersDto()}.toList()

        private fun FavouriteOffers.mapFavouriteOfferDto(): PreviewFavouriteOffer = PreviewFavouriteOffer().apply {
           nationalId=this@mapFavouriteOfferDto.nationalId
            //offer = this@mapFavouriteOfferDto.offer?.mapOffersDto()
        }

        fun List<FavouriteOffers>.mapFavouriteOffer(): List<PreviewFavouriteOffer> = this.map { it.mapFavouriteOfferDto() }.toList()
    }
}