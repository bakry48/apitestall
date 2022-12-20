package com.example.firstapi.services.impl

import com.example.firstapi.entity.Customer
import com.example.firstapi.entity.CustomerFeedback
import com.example.firstapi.entity.Offer
import com.example.firstapi.entity.User
import com.example.firstapi.repository.IcustomerRepo
import com.example.firstapi.repository.IcustomerfeedBackrepo
import com.example.firstapi.repository.IuserRepo
import com.example.firstapi.util.Response
import com.example.firstapi.util.ResponseStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired
    private lateinit var iUserrepo: IuserRepo

    fun addUser(userEntity: User):Response<String>{
        iUserrepo.save(userEntity)
       return Response(status = ResponseStatus.SUCCESS , data = "User Added Successfully")
    }

    fun getUsers():Response<List<User>>{
       return Response(status = ResponseStatus.SUCCESS , data = iUserrepo.findAll())
    }

}