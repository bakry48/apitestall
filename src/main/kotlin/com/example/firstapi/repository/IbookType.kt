package com.example.firstapi.repository

import com.example.firstapi.models.entity.BooksType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IbookType : JpaRepository<BooksType , Long> {
}