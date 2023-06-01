package com.example.firstapi.controller

import com.example.firstapi.models.dto.CustomerHistoryDto
import com.example.firstapi.models.dto.MerchantCategoryDsquareall
import com.example.firstapi.models.dto.MerchantListDsquareall
import com.example.firstapi.models.dto.VoucherDetails
import com.example.firstapi.models.vo.DSquareVoucherVo
import com.example.firstapi.services.DsquareServices
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.servlet.function.ServerResponse.async
import java.math.BigDecimal
import java.time.LocalDate
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor

@RestController
class DsquareController @Autowired constructor(val dSquareService: DsquareServices,val asyncExecutor: Executor) {
    @GetMapping("/dsquare/GetCustomerHistory")
    fun GetCustomerHistory(@RequestParam(required = true) msisdn: String,
                           @RequestParam(required = false)  statusId: Int?,
                           @RequestParam(required = false) lang: String?,
                           @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) fromDate: LocalDate?,
                           @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) toDate: LocalDate?


    ):CustomerHistoryDto{
       return dSquareService.getCustomerHistory(msisdn,statusId,lang,fromDate,toDate)
    }
//    @GetMapping("/dsquare/GetCustomerHistory")
//    fun GetCustomerHistory():List<CustomerHistoryDto>{
//        val restTemplate = RestTemplate()
//        val url = "https://stagingcouponzapi.dsquares.com/api/couponz/GetCustomerHistoryJsonResult"
//        val response: ResponseEntity<String> = restTemplate.getForEntity(url, String::class.java)
//        val objectMapper = ObjectMapper()
//        val merchantCategories: Array<CustomerHistoryDto> = objectMapper.readValue(response.body, Array<CustomerHistoryDto>::class.java)
//        return merchantCategories.toList()
//    }
    @GetMapping("/dsquare/category")
    fun GetCategories(
        @RequestParam(required = false) lang: String?
    ):List<MerchantCategoryDsquareall>{
        val restTemplate = RestTemplate()
        val url = "https://stagingcouponzapi.dsquares.com/api/ExternalApis/GetAllActiveMerchantsCategories?lang=${lang}"
        val response: ResponseEntity<String> = restTemplate.getForEntity(url, String::class.java)
        val objectMapper = ObjectMapper()
        val merchantCategories: Array<MerchantCategoryDsquareall> = objectMapper.readValue(response.body, Array<MerchantCategoryDsquareall>::class.java)
        return merchantCategories.toList()
    }
    @GetMapping("/dsquare/merchant_list")
    fun GetMerchantList(
        @RequestParam (required = false) categoryId:BigDecimal?,
        @RequestParam (required = false) language:String?,
    ):List<MerchantListDsquareall>{
        val restTemplate = RestTemplate()
        val url = "https://stagingcouponzapi.dsquares.com/api/Merchants/GetMerchantList?categoryId=${categoryId}&language=${language}"
        val response: ResponseEntity<String> = restTemplate.getForEntity(url, String::class.java)
        val objectMapper = ObjectMapper()
        val merchantCategories: Array<MerchantListDsquareall> = objectMapper.readValue(response.body, Array<MerchantListDsquareall>::class.java)
        return merchantCategories.toList()
    }

    @GetMapping("/dsquare/active_voucher_no")
    fun getActiveVoucherNumber():Long{
        val restTemplate = RestTemplate()
        val url = "https://stagingcouponzapi.dsquares.com/api/couponz/GetCustomerHistoryJsonResult?msisdn=01062662115&lang=en&StatusId=1"
        val response: ResponseEntity<String> = restTemplate.getForEntity(url, String::class.java)
        val objectMapper = ObjectMapper()
        val customerHistoryDto: CustomerHistoryDto = objectMapper.readValue(response.body, CustomerHistoryDto::class.java)
        val dSquareActiveVoucherVo = dSquareService.dSquareVoucherResponse(customerHistoryDto)
        return dSquareActiveVoucherVo
    }
    @GetMapping("/dsquare/active_voucher")
    fun getActiveVoucher(): CustomerHistoryDto? {
        val restTemplate = RestTemplate()
        val url = "https://stagingcouponzapi.dsquares.com/api/couponz/GetCustomerHistoryJsonResult?msisdn=01062662115&lang=en&StatusId=1"
        val response: ResponseEntity<String> = restTemplate.getForEntity(url, String::class.java)
        val objectMapper = ObjectMapper()
        val customerHistoryDto: CustomerHistoryDto? = objectMapper.readValue(response.body, CustomerHistoryDto::class.java)
        return customerHistoryDto
    }
    @GetMapping("/dsquare/active_voucher_list")
    fun getActiveVoucherList():List<VoucherDetails>?{
        val restTemplate = RestTemplate()
        val url = "https://stagingcouponzapi.dsquares.com/api/couponz/GetCustomerHistoryJsonResult?msisdn=01062662115&lang=en&StatusId=2"
        val response: ResponseEntity<String> = restTemplate.getForEntity(url, String::class.java)
        val objectMapper = ObjectMapper()
        val customerHistoryDto: CustomerHistoryDto = objectMapper.readValue(response.body, CustomerHistoryDto::class.java)
        val dSquareActiveVoucherVo = dSquareService.dSquareVoucherResponseList(customerHistoryDto)
        return dSquareActiveVoucherVo
    }
    @GetMapping("/dsquare/active_voucher_map_list")
    fun getActiveVoucherMapList():CompletableFuture<List<DSquareVoucherVo>>?{
        val restTemplate = RestTemplate()
        val url = "https://stagingcouponzapi.dsquares.com/api/couponz/GetCustomerHistoryJsonResult?msisdn=01062662115&lang=en&StatusId=2"
        val response: ResponseEntity<String> = restTemplate.getForEntity(url, String::class.java)
        val objectMapper = ObjectMapper()
        val customerHistoryDto: CustomerHistoryDto = objectMapper.readValue(response.body, CustomerHistoryDto::class.java)
        val dSquareActiveVoucherVo = dSquareService.dSquareVoucherMap(customerHistoryDto)

        return CompletableFuture.supplyAsync({dSquareActiveVoucherVo},asyncExecutor)
    }
}