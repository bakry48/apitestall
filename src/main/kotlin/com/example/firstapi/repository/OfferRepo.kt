package com.example.firstapi.repository

import com.example.firstapi.models.dto.OffersDto
import com.example.firstapi.models.entity.Offer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface OfferRepo : JpaRepository< Offer , Long>{




}