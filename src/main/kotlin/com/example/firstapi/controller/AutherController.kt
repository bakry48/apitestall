package com.example.firstapi.controller

import com.example.firstapi.entity.Auther
import com.example.firstapi.services.impl.AutherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auther")
class AutherController {

    @Autowired
    private lateinit var autherService:AutherService

    @PostMapping("")
    fun autherSave(@RequestBody autherEntity: Auther):Auther{
        return autherService.autherSave(autherEntity)
    }
}