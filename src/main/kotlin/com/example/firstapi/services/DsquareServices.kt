package com.example.firstapi.services

import com.example.firstapi.models.dto.CustomerHistoryDto
import com.example.firstapi.models.dto.VoucherDetails
import com.example.firstapi.models.vo.DSquareVoucherVo
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class DsquareServices {
    private val  customerHistoryUrl = "https://stagingcouponzapi.dsquares.com/api/couponz/GetCustomerHistoryJsonResult?msisdn="
    fun getCustomerHistory(msisdn: String, statusId: Int?, lang: String?): CustomerHistoryDto {
        val restTemplate = RestTemplate()
        val url = "${customerHistoryUrl}${msisdn}&statusid=${statusId}&lang=${lang}"
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
        return DSquareVoucherVo(
            //totalCount = customerHistory?.totalCount ,
            totalCount = noOfEvouchers,
            name="E-voucher",
            status= voucherDetails.status ,
            amount=voucherDetails.amount,
            points=voucherDetails.amount?.times(200.0),
            expiryDate = expiryDate,
            voucherNumber= voucherDetails.voucherNumber,
            imageUrl= logos)

    }
}