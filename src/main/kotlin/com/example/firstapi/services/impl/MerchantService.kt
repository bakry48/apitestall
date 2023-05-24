package com.example.firstapi.services.impl

import com.example.firstapi.models.dto.MerchantCategoriesDto
import com.example.firstapi.models.enums.MerchantCategories
import com.example.firstapi.models.enums.MerchantsLogos
import com.example.firstapi.models.enums.MerchantsLogosch
import com.example.firstapi.services.MerchantsService
import org.springframework.stereotype.Service
import java.util.stream.Collector
import kotlin.streams.toList

@Service
class MerchantService : MerchantsService {
   override fun gerMwerchantsListch() : Array<MerchantsLogosch>{
        val allDifficultiesch: Array<MerchantsLogosch> = MerchantsLogosch.values()
        return allDifficultiesch
    }

    override fun getMerchantsDtoch():List<MerchantsLogosch>{
        return MerchantsLogosch.values().toList().sortedByDescending { it.categories.categoriesId }
    }

    override fun filerMerchants(categoryId:Int):List<MerchantsLogosch>{
        val merchantsList = MerchantsLogosch.values().toList()
       val merchantsFilterList =  merchantsList.filter { it.categories.categoriesId==categoryId }
        return merchantsFilterList
    }

    override fun searchMerchants(merchantname:String):List<MerchantsLogosch>{
        val merchantsList = MerchantsLogosch.values().toList()
        val merchantsFilterList =  merchantsList.filter { it.merchantsNameEn.startsWith(merchantname , true) or it.merchantsNameAr.startsWith(merchantname , true) }
        return merchantsFilterList
    }
    override fun gerMwerchantsList() : Array<MerchantsLogos>{
        val allDifficulties: Array<MerchantsLogos> = MerchantsLogos.values()
        return allDifficulties
    }

    override fun getMerchantsDto():List<MerchantsLogos>{
        return MerchantsLogos.values().toList()
    }

    override fun getMerchantsDtoSorted():List<MerchantsLogos>{
         var lists =  MerchantsLogos.values()
         val listnew = lists.sortedBy { it.merchantsNameAr }
        return listnew.toList()
    }
    override fun getMerchantsLogos() : String{
         val merchats = listOf<MerchantsLogos>()
        val mer = MerchantsLogos.MERCHANT_2.merchantsNameAr
        return mer

    }

    override fun getCategoriesDto():List<MerchantCategories>{
        return MerchantCategories.values().toList()
    }
}