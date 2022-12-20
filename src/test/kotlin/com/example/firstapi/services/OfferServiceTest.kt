package com.example.firstapi.services

import com.example.firstapi.entity.Offer
import com.example.firstapi.repository.IAutherRepository
import com.example.firstapi.repository.IOfferRepo
import com.example.firstapi.services.impl.OfferService
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import io.mockk.every
import org.assertj.core.api.Assertions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional
import java.io.File
@SpringBootTest
@ActiveProfiles("test")
@Transactional
internal class OfferServiceTest() {
    @Autowired
    lateinit var offerService: OfferService
     val offerEntity= Offer()
    @Autowired
    private lateinit var offerRepository: IOfferRepo
    val mapper = jacksonObjectMapper()
    @BeforeEach
    fun setUp() {
    }

    @Test
    fun `add offers`() {
        val addOffer : Offer =mapper.readValue(
            File("src/test/resources/mock/offer.json"),
            Offer::class.java
        )
        Assertions.assertThat(offerService.saveOffer(addOffer))
    }

    @Test
    fun `get Offers`(){
        val getOffer : Offer =mapper.readValue(
            File("src/test/resources/mock/offer.json")
        )
        Assertions.assertThat(offerService.getOffers()).isNotNull
    }

}