package com.example.firstapi.controller

import com.example.firstapi.mapper.MapResponeMapper.Companion.mapMerchants
import com.example.firstapi.mapper.MapResponeMapper.Companion.mapMerchantsCategories
import com.example.firstapi.mapper.MapResponeMapper.Companion.mapMerchantsch
import com.example.firstapi.models.dto.MerchantCategoriesDto
import com.example.firstapi.models.dto.MerchantsLogo
import com.example.firstapi.models.dto.MerchantsLogoch
import com.example.firstapi.models.enums.MerchantCategories
import com.example.firstapi.models.enums.MerchantsLogos
import com.example.firstapi.models.enums.MerchantsLogosch
import com.example.firstapi.services.impl.MerchantService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.Min
@Validated
@RestController
class MerchantsController( val merchantService: MerchantService) {
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
    @GetMapping("/merchantlistsorted")
    fun merlistsorted():List<MerchantsLogo>{
        return merchantService.getMerchantsDtoSorted().mapMerchants()
    }

    @GetMapping("/merchantlistch")
    fun merlistch():List<MerchantsLogosch>{
        return merchantService.gerMwerchantsListch().toList()
    }
    @GetMapping("/merchantlistdtoch")
    fun merlistdtoch():Map<String  , List<MerchantsLogoch>>{
        return merchantService.getMerchantsDtoch().sortedByDescending { it.categories }.mapMerchantsch().groupBy { it.merchants!! }
    }


    @GetMapping("/merchantfilterlis/{categotyId}")
    fun merfilterlist(@PathVariable @Min(value=1) categotyId:Int):List<MerchantsLogoch>{
        return merchantService.filerMerchants(categotyId).mapMerchantsch()
    }

    @GetMapping("/merchantsearchlis/{merchantname}")
    fun merfilterlist(@PathVariable merchantname:String):List<MerchantsLogoch>{
        return merchantService.searchMerchants(merchantname).mapMerchantsch()
    }

    @GetMapping("/merchantcategory")
    fun getcategory():Map<String , List<MerchantCategoriesDto>>{
        return merchantService.getCategoriesDto().mapMerchantsCategories(merchantService.getMerchantsDtoch()).sortedByDescending { it.categoryName }.groupBy { it.categoryName!! }
    }
}