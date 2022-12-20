package com.example.firstapi.repository

import com.example.firstapi.entity.Customer
import com.example.firstapi.entity.CustomerFeedback
import com.example.firstapi.entity.Offer
import com.example.firstapi.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface IuserRepo : JpaRepository<User, Long> {


}