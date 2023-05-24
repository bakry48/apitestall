package com.example.firstapi.services

import com.example.firstapi.models.enums.MerchantCategories
import com.example.firstapi.models.enums.MerchantsLogos
import com.example.firstapi.models.enums.MerchantsLogosch
import org.springframework.stereotype.Service

@Service
interface MerchantsService {
    fun gerMwerchantsListch() : Array<MerchantsLogosch>

    fun getMerchantsDtoch():List<MerchantsLogosch>

    fun filerMerchants(categoryId:Int):List<MerchantsLogosch>

    fun searchMerchants(merchantname:String):List<MerchantsLogosch>
    fun gerMwerchantsList() : Array<MerchantsLogos>
    fun getMerchantsDto():List<MerchantsLogos>

    fun getMerchantsDtoSorted():List<MerchantsLogos>
    fun getMerchantsLogos() : String
    fun getCategoriesDto():List<MerchantCategories>
}