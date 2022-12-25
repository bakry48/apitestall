package com.example.firstapi.mapper

import com.example.firstapi.models.dto.BooksDto
import com.example.firstapi.models.entity.Books
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
abstract class BooksMapper {



    abstract fun toBooksDto(books : Books):BooksDto
}