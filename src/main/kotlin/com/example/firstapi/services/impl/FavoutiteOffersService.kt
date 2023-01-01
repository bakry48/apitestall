package com.example.firstapi.services.impl

import com.example.firstapi.mapper.FavouriteOffersMapper
import com.example.firstapi.mapper.MapResponeMapper.Companion.mapFavouriteOffer
import com.example.firstapi.models.dto.FavouriteOffersDto
import com.example.firstapi.models.dto.PreviewFavouriteOffer
import com.example.firstapi.models.entity.FavouriteOffers
import com.example.firstapi.models.enums.Status
import com.example.firstapi.models.projections.FavouriteOfferProjection
import com.example.firstapi.repository.FavouriteOffersRepo
import com.example.firstapi.repository.OfferRepo
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service

@Service
class FavoutiteOffersService (
    private val favouriteOffersRepo: FavouriteOffersRepo,
    private val offerRepo: OfferRepo
) {
      val favouriteOfferMapper = Mappers.getMapper(FavouriteOffersMapper::class.java)
    fun isOfferFavouriteBefore(nationalId : String , offerId : Long) : Boolean
    {
      return  favouriteOffersRepo.existsByNationalIdAndOffer_Id(nationalId , offerId)
    }

    fun saveOfferAsAfavourite(favouriteOffersDto : FavouriteOffersDto) : String {
        val favouriteOffersEntity = favouriteOfferMapper.toFavouriteOffersEntity(favouriteOffersDto)
        val offerEntity = offerRepo.findById(/* id = */ favouriteOffersEntity.offer?.id!!).get()
        var offerExist : Boolean = offerRepo.existsById(favouriteOffersEntity.offer?.id!!)
        return if(isOfferFavouriteBefore(favouriteOffersEntity.nationalId , favouriteOffersEntity.offer?.id!!)) {
            "Offers is A Favoutite"
        }else if(offerEntity.status != Status.PUBLISHED){
            "Offers is Not Published"
        }else if(!offerExist){
            "Offers  Not Founded"
        }else{
            favouriteOffersRepo.save(favouriteOffersEntity)
            "Offer Saved As A favourite $offerExist"
        }
    }

    fun unSaveOfferAsFavourite(favouriteOffersDto: FavouriteOffersDto) : String {
        val favouriteOffersEntity = favouriteOfferMapper.toFavouriteOffersEntity(favouriteOffersDto)
      if(!isOfferFavouriteBefore(favouriteOffersEntity.nationalId , favouriteOffersEntity.offer?.id!!))
      {
          return "this offer not found in favourite"
      }
         favouriteOffersRepo.deleteByNationalIdAndOffer_Id(favouriteOffersEntity.nationalId , favouriteOffersEntity.offer?.id!!)
        return "Offer Removed from Favourite"
    }

     fun delIfNotPublished():Int{
         return favouriteOffersRepo.setExpiredStatus()
     }

    fun getAllFav():List<FavouriteOfferProjection>{
        return favouriteOffersRepo.findAllFavActive()
    }

    fun findAllFavOfferDto(): List<PreviewFavouriteOffer>{
        return favouriteOffersRepo.findAll().mapFavouriteOffer()
    }
}