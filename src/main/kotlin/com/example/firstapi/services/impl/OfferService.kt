package com.example.firstapi.services.impl

import com.example.firstapi.models.entity.Offer
import com.example.firstapi.projections.OfferProjections
import com.example.firstapi.repository.IOfferRepo
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Sort.Direction
import org.springframework.stereotype.Service

@Service
class OfferService {
    @Autowired
    private lateinit var offerRepo: IOfferRepo

      fun saveOffer(offerentity : Offer):String{
         offerRepo.save(offerentity)
         return "Your Offer Inserted"
     }
    fun updateOffer(offerentity : Offer):String{
        var current : Optional<Offer> = offerRepo.findById(offerentity.id!!)
        var offeren= current.get()
        offeren.OfferNameAr=offerentity.OfferNameAr
        offerRepo.save(offeren)
        offerRepo.flush()
        return "Your Offer Updated ${offeren.OfferNameAr}"
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
    fun getOfferByName(name:String):List<Offer>{

        return offerRepo.getOfferByName(name)
    }

    fun delOffer(id:Long):String{
        offerRepo.deleteById(id)
        return "Deleted"
    }
}