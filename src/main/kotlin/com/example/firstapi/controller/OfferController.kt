package com.example.firstapi.controller

import com.example.firstapi.mapper.MapResponeMapper.Companion.mapMerchants
import com.example.firstapi.mapper.MapResponeMapper.Companion.mapPublishedOffer
import com.example.firstapi.models.dto.FavouriteOffersDto
import com.example.firstapi.models.dto.MerchantsLogo
import com.example.firstapi.models.dto.OffersDto
import com.example.firstapi.models.entity.Offer
import com.example.firstapi.models.enums.MerchantsLogos
import com.example.firstapi.models.projections.OfferProjections
import com.example.firstapi.services.impl.FavoutiteOffersService
import com.example.firstapi.services.impl.OfferService
import com.example.firstapi.services.impl.MerchantService
import com.example.firstapi.util.Response
import com.example.firstapi.util.ResponseStatus
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import io.swagger.*
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import javax.validation.constraints.Max

@RestController
@RequestMapping("/offer")
class OfferController(
      val offerservice : OfferService,
      val favouriteOffersService: FavoutiteOffersService,
    val merchantService: MerchantService
            ) {



    @PostMapping("")
    fun saveOffer(@RequestBody offerEntity: Offer):String{
        return offerservice.saveOffer(offerEntity)
    }


    @PutMapping("")
    fun updateOffer(@RequestBody offerEntity: Offer):String{

        return offerservice.updateOffer(offerEntity)
    }
    @ApiOperation(value = "get all offers" , response = String::class , responseContainer = "List")

    @ApiResponses(
        value =[ApiResponse(description = "success" , responseCode = "200") ,
                ApiResponse(description = "failed" , responseCode = "500")
        ]
    )
    @ApiImplicitParams(
        ApiImplicitParam(
            name = "Authorization",
            value = "Access Token",
            required = true,
            paramType = "header",
            dataTypeClass = String::class
        ), ApiImplicitParam(
            name = "Cookie", value = "tokenval", required = true, paramType = "header", dataTypeClass = String::class
        ), ApiImplicitParam(
            name = "X-Locale",
            defaultValue = "en",
            allowableValues = "en, ar",
            required = false,
            paramType = "header",
            dataTypeClass = String::class
        )

    )
    @GetMapping("")
    fun getOffers(): List<OfferProjections> {
        return offerservice.getOffers()
    }
//    @GetMapping("/{name}")
//    fun getOfferByName(@PathVariable  name:String): ResponseEntity<*> {
//
//        return ResponseEntity.ok(offerservice.getOfferByName(name))
//    }
    @GetMapping("/offerexist/{offerNameEn}")
    fun getOfferByNameEn(@PathVariable  offerNameEn:String):Boolean{
        return offerservice.existOfferByOffernameEn(offerNameEn)
    }

    @GetMapping("sort")
    fun getOffersWithSort(@RequestParam sortBy:String , isAsc:Boolean , size:Int , page:Int): Page<Offer> {
        return offerservice.getOffersWithSort(sortBy , isAsc , size , page)
    }

    @DeleteMapping("/{id}")
    fun delOffer(@PathVariable @Max(value = 5) id:Long):String{
       return offerservice.delOffer(id)
    }

    @PostMapping("/favourite")
    fun saveOfferAsFav(@RequestBody favouriteOffersDto: FavouriteOffersDto) : String{
       return favouriteOffersService.saveOfferAsAfavourite(favouriteOffersDto)
    }

    @DeleteMapping("/favourite")
    fun unSaveOfferAsFav(@RequestParam id: Long) : String{
        return favouriteOffersService.unSaveOfferAsFavourite(id)
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



    // flag favourite return offers and have offer is a favourite or not

    @GetMapping("/offerspublishedlist")
    fun getPublishedOffers(): Response<*>{
       return Response(status = ResponseStatus.SUCCESS , data = offerservice.findOffersPublished().let {list->
           list.mapPublishedOffer(
               favouriteOffersService.getAllFavouriteOfferByOfferId(list?.mapNotNull{ it.id })
           )

       })

    }
    @GetMapping("/getbyone/{id}")
    fun getByOne(@PathVariable  id: Long ): Response<Offer>{
        return Response(status = ResponseStatus.SUCCESS , data = offerservice.getByOne(id))
    }
    @GetMapping("/merchants")
    fun merchants(): String{
        return merchantService.getMerchantsLogos()
    }
    @GetMapping("/merchantlist")
    fun merlist():List<MerchantsLogos>{
        return merchantService.gerMwerchantsList().toList()
    }
    @GetMapping("/merchantlistdto")
    fun merlistdto():List<MerchantsLogo>{
        return merchantService.getMerchantsDto().mapMerchants()
    }
}