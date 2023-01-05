package com.example.firstapi.services.impl

import com.example.firstapi.mapper.FavouriteOffersMapper
import com.example.firstapi.mapper.MapResponeMapper.Companion.mapFavouriteOffer
import com.example.firstapi.models.dto.FavouriteOffersDto
import com.example.firstapi.models.dto.PreviewFavouriteOffer
import com.example.firstapi.models.entity.FavouriteOffers
import com.example.firstapi.models.enums.Status
import com.example.firstapi.models.projections.FavouriteOfferProjection
import com.example.firstapi.repository.FavouriteOffersRepo
import com.example.firstapi.repository.IOfferRepo
import org.mapstruct.factory.Mappers
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service
import java.sql.SQLIntegrityConstraintViolationException

@Service
class FavoutiteOffersService (
    private val favouriteOffersRepo: FavouriteOffersRepo,
    private val offerRepo: IOfferRepo
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
        try {
            return  if(offerEntity.status != Status.PUBLISHED){
                "Offers is Not Published"
            }else if(!offerExist){
                "Offers  Not Founded"
            }else{
                favouriteOffersRepo.save(favouriteOffersEntity)
                "Offer Saved As A favourite $offerExist"
            }
        }catch (sq : DataIntegrityViolationException){
            return "Offers as Favourite"
        }

    }

    fun unSaveOfferAsFavourite(favouriteOffersDto: FavouriteOffersDto) : String {
        val favouriteOffersEntity = favouriteOfferMapper.toFavouriteOffersEntity(favouriteOffersDto)

        val favouriteOverRemove =  favouriteOffersRepo.deleteByNationalIdAndOffer_Id(favouriteOffersEntity.nationalId , favouriteOffersEntity.offer?.id!!)
        if(favouriteOverRemove == 0) {
            return "$favouriteOverRemove not found"
        }else{

            return " $favouriteOverRemove Offer Removed from Favourite"
        }
    }

     fun delIfNotPublished():Int{
         return favouriteOffersRepo.setExpiredStatus()
     }

    fun getAllFav():List<FavouriteOfferProjection>{
        return favouriteOffersRepo.findAllFavActive()
    }

    fun findAllFavOfferDto(): List<PreviewFavouriteOffer>{

        return favouriteOffersRepo.findAllFavActivedto("2845212554558").mapFavouriteOffer()
    }

    // favourite flag function get all fav offer to one user by list of offer ids
    fun getAllFavouriteOfferByOfferId(offerId : List<Long>):List<FavouriteOffers>{
        return favouriteOffersRepo.findByNationalIdAndOffer_IdAndActiveTrue(offerId = offerId)
    }

//    fun getAllFavouriteOfferByOfferId():List<FavouriteOffers>{
//        return favouriteOffersRepo.findByNationalIdAndOffer_IdAndActiveTrue()
//    }
}