package com.example.firstapi.repository

import com.example.firstapi.entity.Books
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IBooks : JpaRepository <Books, Long> {
}