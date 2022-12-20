package com.example.firstapi.controller

import com.example.firstapi.entity.Customer
import com.example.firstapi.entity.User
import com.example.firstapi.services.impl.CustomerService
import com.example.firstapi.services.impl.UserService
import com.example.firstapi.util.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.persistence.Entity

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @PostMapping("")
    fun addUser(@RequestBody userEntity : User):Response<String>{
        return userService.addUser(userEntity)
    }

    @GetMapping("")
    fun getCustomers():Response<List<User>>{
        return userService.getUsers()
    }
}