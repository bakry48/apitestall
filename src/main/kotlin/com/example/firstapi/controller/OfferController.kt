package com.example.firstapi.controller

import com.example.firstapi.models.entity.Offer
import com.example.firstapi.projections.OfferProjections
import com.example.firstapi.services.impl.OfferService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/offer/")
class OfferController {

    @Autowired
    private lateinit var offerservice : OfferService

    @PostMapping("")
    fun saveOffer(@RequestBody offerEntity: Offer):String{
        return offerservice.saveOffer(offerEntity)
    }


    @PutMapping("")
    fun updateOffer(@RequestBody offerEntity: Offer):String{

        return offerservice.updateOffer(offerEntity)
    }
    @GetMapping("")
    fun getOffers(): List<OfferProjections> {
        return offerservice.getOffers()
    }
    @GetMapping("/{name}")
    fun getOfferByName(@PathVariable  name:String): List<Offer> {
        return offerservice.getOfferByName(name)
    }
    @GetMapping("/offerexist/{offerNameEn}")
    fun getOfferByNameEn(@PathVariable  offerNameEn:String):Boolean{
        return offerservice.existOfferByOffernameEn(offerNameEn)
    }

    @GetMapping("sort")
    fun getOffersWithSort(@RequestParam sortBy:String , isAsc:Boolean , size:Int , page:Int): Page<Offer> {
        return offerservice.getOffersWithSort(sortBy , isAsc , size , page)
    }

    @DeleteMapping("/{id}")
    fun delOffer(@PathVariable id:Long):String{
       return offerservice.delOffer(id)
    }

}