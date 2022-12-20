package com.example.firstapi.repository

import com.example.firstapi.entity.BooksType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IBooksType : JpaRepository<BooksType , Long>{
}