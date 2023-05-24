package com.example.firstapi.mapper


import com.example.firstapi.mapper.MapResponeMapper.Companion.mapMerchantscategoryDto
import com.example.firstapi.models.dto.*
import com.example.firstapi.models.entity.FavouriteOffers
import com.example.firstapi.models.entity.Offer
import com.example.firstapi.models.enums.MerchantCategories
import com.example.firstapi.models.enums.MerchantsLogos
import com.example.firstapi.models.enums.MerchantsLogosch
import com.example.firstapi.services.impl.MerchantService
import com.google.common.reflect.TypeToken
import java.util.*
import com.google.gson.Gson

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
            expireDate=this@mapOffersDto.expiryDate.toString()

        }

        fun List<Offer>.mapOffer():List<OffersDto> = this.map{it.mapOffersDto()}.toList()

        fun List<MerchantsLogos>.mapMerchants():List<MerchantsLogo> = this.map{it.mapMerchantsDto()}.toList()

        private fun MerchantsLogos.mapMerchantsDto(): MerchantsLogo = MerchantsLogo().apply {
            id=this@mapMerchantsDto.id
            merchantsNameAr=this@mapMerchantsDto.merchantsNameAr
            merchantsNameEn=this@mapMerchantsDto.merchantsNameEn
            logoUrl=this@mapMerchantsDto.logoUrl
            merchants= getLocalForLanguage(Pair(this@mapMerchantsDto.merchantsNameEn , this@mapMerchantsDto.merchantsNameAr))

        }


        fun List<MerchantsLogosch>.mapMerchantsch():List<MerchantsLogoch> = this.map{it.mapMerchantschDto()}.toList()

        private fun MerchantsLogosch.mapMerchantschDto(): MerchantsLogoch = MerchantsLogoch().apply {
            id=this@mapMerchantschDto.id
            merchantsNameAr=null
            merchantsNameEn=this@mapMerchantschDto.merchantsNameEn
            logoUrl=this@mapMerchantschDto.logoUrl
            merchants= getLocalForLanguage(Pair(this@mapMerchantschDto.merchantsNameEn , this@mapMerchantschDto.merchantsNameAr))
            merchantsId = this@mapMerchantschDto.categories.categoriesId


        }

        fun List<MerchantCategories>.mapMerchantsCategories(merchantOffer : List<MerchantsLogosch>):List<MerchantCategoriesDto> = this.map{it.mapMerchantscategoryDto(merchantOffer)}
        val merchantService: MerchantService = MerchantService()
        //val taglineGenericDtoType = object : TypeToken<List<MerchantsLogoch>>() {}.type
        private fun MerchantCategories.mapMerchantscategoryDto(merchantOffer : List<MerchantsLogosch>) : MerchantCategoriesDto = MerchantCategoriesDto().apply {
            categoryId=this@mapMerchantscategoryDto.categoriesId
            categoryName=this@mapMerchantscategoryDto.categoriesNameAr
            //merchantsList= merchantService.filerMerchants(this@mapMerchantscategoryDto.categoriesId).mapMerchantsch()
            //merchantsList = this@mapMerchantscategoryDto.merchantsList?.let{ merch -> Gson().fromJson(merch , taglineGenericDtoType) as List<MerchantsLogoch> }
            //tagline -> Gson().fromJson(tagline, taglineGenericDtoType
            merchantsList = merchantOffer.filter { it.categories.categoriesId==this@mapMerchantscategoryDto.categoriesId }.mapMerchantsch()
        }
        private fun getLocalForLanguage(data: Pair<String?, String?>) : String?{
         val local = Locale.getDefault().displayLanguage
            return if(local=="English" && !data.first.isNullOrEmpty()) data.first else data.second
        }
        private fun FavouriteOffers.mapFavouriteOfferDto(): PreviewFavouriteOffer = PreviewFavouriteOffer().apply {
           nationalId=this@mapFavouriteOfferDto.nationalId
            //offer = this@mapFavouriteOfferDto.offer?.mapOffersDto()
        }

        fun List<FavouriteOffers>.mapFavouriteOffer(): List<PreviewFavouriteOffer> = this.map { it.mapFavouriteOfferDto() }.toList()
    }

//    fun List<MerchantsLogo>.mapMerchantsLogoList():List<MerchantsLogoDto> = this.map { it.mapMerchantsLogo() }.toList()
//
//    private fun MerchantsLogo.mapMerchantsLogo() : MerchantsLogoDto = MerchantsLogoDto().apply {
//        id = this@mapMerchantsLogo.id
//        merchantsName = mapLocaleSpecificData(Pair(this@mapMerchantsLogo.merchantsNameEn , this@mapMerchantsLogo.merchantsNameAr))
//        logoUrl = this@mapMerchantsLogo.logoUrl
//    }
}