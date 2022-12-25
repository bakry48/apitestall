package com.example.firstapi.repository

import com.example.firstapi.models.entity.Auther
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface IAutherRepository : JpaRepository<Auther, Long>{



}