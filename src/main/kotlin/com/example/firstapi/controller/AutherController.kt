package com.example.firstapi.controller

import com.example.firstapi.models.dto.AutherDto
import com.example.firstapi.models.entity.Auther
import com.example.firstapi.services.impl.AutherService
import com.example.firstapi.util.Response
import com.example.firstapi.util.ResponseStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.Max

@Validated
@RestController
@RequestMapping("/auther")
class AutherController {

    @Autowired
    private lateinit var autherService:AutherService

    @PostMapping("")
    fun autherSave(@RequestBody autherDto: AutherDto): Auther {
        return autherService.autherSave(autherDto)
    }

    @GetMapping("")
    fun getAllAuthor(): ResponseEntity<*> {
     return ResponseEntity.ok( Response( status = ResponseStatus.SUCCESS, data = autherService.getAllAuther()))
    }

    @GetMapping("/{id}")
    fun getAuthorById(@PathVariable @Max(50) id:Long): Response<Auther> {
        return Response( status = ResponseStatus.SUCCESS, data = autherService.getAuthorById(id).orElseThrow())
    }
}