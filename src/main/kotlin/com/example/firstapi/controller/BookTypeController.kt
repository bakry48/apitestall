package com.example.firstapi.controller

import com.example.firstapi.models.entity.BooksType
import com.example.firstapi.services.impl.BookTypeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bookType")
class BookTypeController {


    @Autowired
    final lateinit var bookTypeService: BookTypeService
    @PostMapping("")
    fun saveBook(@RequestBody bookTypeEntity : BooksType):String
    {
        return  bookTypeService.saveBookType(bookTypeEntity)
    }
}