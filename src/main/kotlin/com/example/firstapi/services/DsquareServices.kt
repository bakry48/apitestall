package com.example.firstapi.services

import com.example.firstapi.models.dto.CustomerHistoryDto
import com.example.firstapi.models.dto.VoucherDetails
import com.example.firstapi.models.vo.DSquareVoucherVo
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.time.LocalDate
import java.util.concurrent.CompletableFuture
@Service
class DsquareServices {
    private val  customerHistoryUrl = "https://stagingcouponzapi.dsquares.com/api/couponz/GetCustomerHistoryJsonResult?msisdn="
    fun getCustomerHistory(msisdn: String, statusId: Int?, lang: String?,fromDate: LocalDate? , toDate: LocalDate?): CustomerHistoryDto {
        val restTemplate = RestTemplate()
       var url = "${customerHistoryUrl}${msisdn}&statusid=${statusId}&lang=${lang}"
        if(fromDate!=null && toDate!=null) {
             url = "${customerHistoryUrl}${msisdn}&statusid=${statusId}&lang=${lang}&from=${fromDate}&to=${toDate}"
        }


        val response: ResponseEntity<String> = restTemplate.getForEntity(url, String::class.java)
        val objectMapper = ObjectMapper()
        return objectMapper.readValue(response.body, CustomerHistoryDto::class.java)
    }
    fun dSquareVoucherResponse(customerHistory: CustomerHistoryDto?): Long =
        customerHistory?.voucherDetails?.size!!.toLong()
    fun dSquareVoucherResponseList(customerHistory: CustomerHistoryDto?): List<VoucherDetails>? =
        customerHistory?.voucherDetails?.filter { !it.id!!.equals(1) }

    fun dSquareVoucherMap(customerHistory: CustomerHistoryDto?): List<DSquareVoucherVo>? =
        customerHistory?.voucherDetails?.map { acc -> dSquareVoucher(customerHistory,acc,customerHistory.voucherDetails.size) }

    private fun dSquareVoucher(customerHistory: CustomerHistoryDto?, voucherDetails: VoucherDetails , noOfEvouchers : Int): DSquareVoucherVo {
        val expiryDate = voucherDetails.expiryDate
        val logos = "e-vouchers"+ (".png")
        val restTemplate = RestTemplate()
        val url = "https://stagingcouponzapi.dsquares.com/api/couponz/GetCustomerHistoryJsonResult?msisdn=01062662115&lang=en&StatusId=2"
        val response: ResponseEntity<String> = restTemplate.getForEntity(url, String::class.java)
        val objectMapper = ObjectMapper()
        val customerHistoryDto: CustomerHistoryDto = objectMapper.readValue(response.body, CustomerHistoryDto::class.java)
        val urls = "https://stagingcouponzapi.dsquares.com/api/couponz/getCustomerHistoryJsonResult?msisdn=01062662115&lang=en&StatusId=2"
        val responses: ResponseEntity<String> = restTemplate.getForEntity(urls, String::class.java)
        val customerHistoryDtos: CustomerHistoryDto = objectMapper.readValue(responses.body, CustomerHistoryDto::class.java)
        val activeVouchersDeferred =  dSquareVoucherResponse(customerHistoryDtos).toInt()
        return DSquareVoucherVo(
            totalCount = activeVouchersDeferred,
            //totalCount = customerHistory?.totalCount ,
            //totalCount = noOfEvouchers,
            name="E-voucher",
            status= voucherDetails.status ,
            amount=voucherDetails.amount,
            points=voucherDetails.amount?.times(200.0),
            expiryDate = expiryDate,
            voucherNumber= voucherDetails.voucherNumber,
            imageUrl= logos)

    }
}