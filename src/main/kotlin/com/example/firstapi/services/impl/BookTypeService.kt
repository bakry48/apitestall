package com.example.firstapi.services.impl

import com.example.firstapi.mapper.BookTypeMappers
import com.example.firstapi.mapper.FavouriteOffersMapper
import com.example.firstapi.models.dto.BookTypeDto
import com.example.firstapi.models.entity.BooksType
import com.example.firstapi.repository.IbookType
import org.mapstruct.factory.Mappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookTypeService {

    @Autowired
    final lateinit var bookRepo:IbookType

    val bookTypeMapper = Mappers.getMapper(BookTypeMappers::class.java)
    fun saveBookType(bookTypeEntity : BooksType):String{
        bookRepo.save(bookTypeEntity)
        return "Added Type"
    }

    fun saveDto(bookTypeDto: BookTypeDto): String{
        val btypeEntity= bookTypeMapper.toBookTypeEntity(bookTypeDto)
        bookRepo.save(btypeEntity)
        return "OK"
    }
}