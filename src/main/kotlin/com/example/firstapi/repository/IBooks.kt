package com.example.firstapi.repository

import com.example.firstapi.models.dto.BooksDto
import com.example.firstapi.models.entity.Books
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface IBooks : JpaRepository <Books, Long> {


   @Transactional
   @Modifying
   fun deleteByAutherId(autherId : Long):Long
   fun findByAutherId(autherId: Long):List<Books>

}