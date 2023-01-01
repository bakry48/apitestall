package com.example.firstapi.services

import com.example.firstapi.repository.FavouriteOffersRepo
import com.example.firstapi.services.impl.FavoutiteOffersService
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional
import io.mockk.every
import io.mockk.mockk
@SpringBootTest
@ActiveProfiles("test")
@Transactional
class FavouriteOffersTest {
    lateinit var favoutiteOffersService: FavoutiteOffersService
    val mapper = jacksonObjectMapper()
    val favouriteOffersRepo = mockk<FavouriteOffersRepo>()
}