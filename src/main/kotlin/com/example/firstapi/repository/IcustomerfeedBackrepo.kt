package com.example.firstapi.repository

import com.example.firstapi.entity.CustomerFeedback
import com.example.firstapi.entity.Offer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface IcustomerfeedBackrepo : JpaRepository<CustomerFeedback , Long> {

    open fun existsByNationalIdAndOffer(nationalId : String , offer : Offer):Boolean

     // that's same below
     open fun findByOfferId(offerid : Long):List<CustomerFeedback>
      // that's same above
     @Query(value="select feed.nationalId from CustomerFeedback feed join feed.offer off where off.id = :offerid")
    open fun findFeedByOfferId(offerid : Long):List<CustomerFeedback>



}