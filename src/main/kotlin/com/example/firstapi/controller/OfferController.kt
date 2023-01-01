package com.example.firstapi.controller

import com.example.firstapi.models.dto.FavouriteOffersDto
import com.example.firstapi.models.dto.OfferDto
import com.example.firstapi.models.dto.OffersDto
import com.example.firstapi.models.entity.FavouriteOffers
import com.example.firstapi.models.entity.Offer
import com.example.firstapi.models.projections.OfferProjections
import com.example.firstapi.services.impl.FavoutiteOffersService
import com.example.firstapi.services.impl.OfferService
import com.example.firstapi.util.Response
import com.example.firstapi.util.ResponseStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/offer")
class OfferController(
      val offerservice : OfferService,
      val favouriteOffersService: FavoutiteOffersService
            ) {



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
    fun getOfferByName(@PathVariable  name:String): ResponseEntity<*> {
        var offer = offerservice.getOfferByName(name)
        var offerDto = OfferDto()
        offerDto.offerNameAr = offer.offerNameAr
        return ResponseEntity.ok(offerDto)
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

    @PostMapping("/favourite")
    fun saveOfferAsFav(@RequestBody favouriteOffersDto: FavouriteOffersDto) : String{
       return favouriteOffersService.saveOfferAsAfavourite(favouriteOffersDto)
    }

    @DeleteMapping("/favourite")
    fun unSaveOfferAsFav(@RequestBody favouriteOffersDto: FavouriteOffersDto) : String{
        return favouriteOffersService.unSaveOfferAsFavourite(favouriteOffersDto)
    }

    @DeleteMapping("/fav")
    fun delIf():Int{
      return favouriteOffersService.delIfNotPublished()
    }

    @GetMapping("/alloffer")
    fun allOffer(): ResponseEntity<*>{
       return ResponseEntity.ok(offerservice.findAllOffer())
    }
    @GetMapping("/allofferdto")
    fun allOfferDto(): ResponseEntity<*>{
        return ResponseEntity.ok(offerservice.findAllOfferDto())
    }
    @GetMapping("/favouriteofferlist")
    fun getallfavourite() : Response<*>{
      return  Response(status = ResponseStatus.SUCCESS , data= favouriteOffersService.getAllFav() )
    }

    @GetMapping("/favouriteofferlistdto")
    fun getallfavouriteDto() : Response<*>{
        return  Response(status = ResponseStatus.SUCCESS , data= favouriteOffersService.findAllFavOfferDto() )
    }
}