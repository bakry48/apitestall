package com.example.firstapi.repository

import com.example.firstapi.entity.Auther
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IAutherRepository : JpaRepository<Auther, Long>{

}