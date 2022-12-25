package com.example.firstapi.repository

import com.example.firstapi.models.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IuserRepo : JpaRepository<User, Long> {


}