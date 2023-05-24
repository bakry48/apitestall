package com.example.firstapi.mapper

import com.example.firstapi.models.dto.BookTypeDto
import com.example.firstapi.models.entity.BooksType
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
abstract class BookTypeMappers {

    abstract fun toBookTypeEntity(bookTypeDto: BookTypeDto): BooksType
}