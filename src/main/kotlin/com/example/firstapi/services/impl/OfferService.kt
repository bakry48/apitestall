package com.example.firstapi.services.impl

import com.example.firstapi.mapper.FavouriteOffersMapper
import com.example.firstapi.mapper.MapResponeMapper.Companion.mapOffer
import com.example.firstapi.mapper.OfferMapper
import com.example.firstapi.mapper.OffersMapper
import com.example.firstapi.models.dto.OfferDto
import com.example.firstapi.models.dto.OffersDto
import com.example.firstapi.models.dto.PreviewFavouriteOffer
import com.example.firstapi.models.entity.Offer
import com.example.firstapi.models.projections.OfferProjections
import com.example.firstapi.repository.IOfferRepo
import org.mapstruct.factory.Mappers
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Sort.Direction
import org.springframework.stereotype.Service

@Service
class OfferService(
    private val offerRepo: IOfferRepo
) {



    val offerMapper = Mappers.getMapper(OffersMapper::class.java)
      fun saveOffer(offerentity : Offer):String{
         offerRepo.save(offerentity)
         return "Your Offer Inserted"
     }
    fun updateOffer(offerentity : Offer):String{
        var current : Optional<Offer> = offerRepo.findById(offerentity.id!!)
        var offeren= current.get()
        offeren.offerNameAr=offerentity.offerNameAr
        offerRepo.save(offeren)
        offerRepo.flush()
        return "Your Offer Updated ${offeren.offerNameAr}"
    }

    fun getOffersWithSort(sortBy:String , isAsc:Boolean , page:Int , size:Int):Page<Offer>{
        var direction = if (isAsc) {
            Direction.ASC
        } else {
            Direction.DESC
        }
        var page:Pageable= PageRequest.of(size , page , Sort.by( direction , sortBy))
        return offerRepo.getOfferWithSortAndPaggination(page)
    }

      fun getOffers():List<OfferProjections>{
          return offerRepo.findAllmine()
      }

      fun existOfferByOffernameEn(offerNameEn : String):Boolean{
          return  offerRepo.existsByOfferNameEn( offerNameEn)
      }
    fun getOfferByName(name:String):Offer{

        return offerRepo.getOfferByName(name)
    }

    fun delOffer(id:Long):String{
        offerRepo.deleteById(id)
        return "Deleted"
    }

    fun findAllOffer():List<OfferProjections>{
       // var offerDto = offerMapper.toDto (offerRepo.findById(id).get())

        return offerRepo.getAllOffer()
    }


   fun findAllOfferDto():List<OffersDto>{
      return offerRepo.findAll().mapOffer()
   }


}