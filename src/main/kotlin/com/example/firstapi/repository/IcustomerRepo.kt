package com.example.firstapi.repository

import com.example.firstapi.entity.Customer
import com.example.firstapi.entity.CustomerFeedback
import com.example.firstapi.entity.Offer
import com.example.firstapi.projections.CustomerProjection
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface IcustomerRepo : JpaRepository<Customer, Long> {

    open fun findByNameContainingAndUserPassword(custname:String , userPass:String):List<Customer>


    open fun findFirstByNameStartingWith(nameStartWith:String):List<CustomerProjection>
}