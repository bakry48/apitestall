package com.example.firstapi.services.impl

import com.example.firstapi.models.entity.BooksType
import com.example.firstapi.repository.IbookType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookTypeService {

    @Autowired
    final lateinit var bookRepo:IbookType

    fun saveBookType(bookTypeEntity : BooksType):String{
        bookRepo.save(bookTypeEntity)
        return "Added Type"
    }
}