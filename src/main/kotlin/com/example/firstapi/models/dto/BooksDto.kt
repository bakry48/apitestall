package com.example.firstapi.models.dto

import com.example.firstapi.models.entity.Auther
import com.example.firstapi.models.entity.BooksType
import java.io.Serializable

/**
 * A DTO for the {@link com.example.firstapi.models.entity.Books} entity
 */
data class BooksDto(

    val title: String? = null,
    val price: Double? = null,
    val autherId: Auther? = null,
    val bookType: BooksType? = null

): Serializable