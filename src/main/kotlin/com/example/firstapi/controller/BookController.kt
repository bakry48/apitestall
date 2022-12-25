package com.example.firstapi.controller

import com.example.firstapi.models.dto.BooksDto
import com.example.firstapi.models.entity.Books
import com.example.firstapi.services.impl.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/book")
class BookController {

    @Autowired
    final lateinit var bookService: BookService
    @PostMapping("")
    fun saveBook(@RequestBody bookEntity : Books):String
    {
      return  bookService.saveBook(bookEntity)
    }

    @GetMapping("")
    fun getAllBooks():List<Books>{
       return bookService.getAllBooks()
    }
    @GetMapping("/{id}")
    fun getBook(@PathVariable id:Long):Books{
        return bookService.getById(id)
    }
    @GetMapping("/author/{id}")
    fun getAllBooks(@PathVariable id:Long):List<Books>{
        return bookService.findByAuthorId(id)
    }

    @DeleteMapping("/author/{id}")
    fun delByAuthorId(@PathVariable id:Long):Long{
        return bookService.delByAuthorId(id)
    }
}