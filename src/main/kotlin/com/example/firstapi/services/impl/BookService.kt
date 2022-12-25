package com.example.firstapi.services.impl

import com.example.firstapi.models.dto.BooksDto
import com.example.firstapi.models.entity.Books
import com.example.firstapi.repository.IBooks
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookService ( private val  ibookRepo : IBooks ) {



    fun saveBook(book : Books):String{
        ibookRepo.save(book)
        return "ADDED SUCCEFULLY"
    }

    fun getAllBooks():List<Books>{

        return ibookRepo.findAll()
       ibookRepo.findAll()
    }

    fun findByAuthorId(id:Long):List<Books>{
        return ibookRepo.findByAutherId(id)
    }

    fun getById(id:Long):Books{
        return ibookRepo.getOne(id)
    }
    fun delByAuthorId(id:Long):Long{
        return ibookRepo.deleteByAutherId(id)
    }
}