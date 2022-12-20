package com.example.firstapi.repository

import com.example.firstapi.entity.CustomerFeedback
import com.example.firstapi.entity.Offer
import com.example.firstapi.projections.OfferProjections
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
interface IOfferRepo: JpaRepository<Offer , Long > {

    // jpql
    @Query(value="select offer from Offer offer where offer.offerNameEn = :offername")
    fun getOfferByName(@Param("offername") offername:String): List<Offer>

    @Query(value="select offer from Offer offer ")
    fun getOfferWithSortAndPaggination(page : Pageable): Page<Offer>
    fun existsByOfferNameEn( offerNameEn: String):Boolean

    @Query(value="select offer from Offer offer ")
    fun findAllmine(): List<OfferProjections>


     override fun deleteById(id:Long)
}