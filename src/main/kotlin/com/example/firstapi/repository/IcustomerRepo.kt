package com.example.firstapi.repository

import com.example.firstapi.models.entity.Customer
import com.example.firstapi.projections.CustomerProjection
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IcustomerRepo : JpaRepository<Customer, Long> {

    open fun findByNameContainingAndUserPassword(custname:String , userPass:String):List<Customer>


    open fun findFirstByNameStartingWith(nameStartWith:String):List<CustomerProjection>
}