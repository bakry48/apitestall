package com.example.firstapi.controller

import com.example.firstapi.entity.Customer
import com.example.firstapi.projections.CustomerProjection
import com.example.firstapi.services.impl.CustomerService
import com.example.firstapi.util.Response
import com.example.firstapi.util.ResponseStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.persistence.Entity

@RestController
@RequestMapping("/customer")
class CustomerController {

    @Autowired
    private lateinit var customerService: CustomerService

    @PostMapping("")
    fun addCustomer(@RequestBody customerEntity : Customer):Response<String>{
        return customerService.addCustomer(customerEntity)
    }

    @GetMapping("")
    fun getCustomers():Response<List<Customer>>{
        return customerService.getCustomers()
    }

    @GetMapping("/filter")
    fun getCustomersbyNameAndPassword(@RequestParam empName:String , @RequestParam pass:String):List<Customer>{
        return customerService.getCustomerByNameAndPassword(empName, pass)
    }

    //get data from projections
    @GetMapping("/projections/{name}")
    fun getCustomerProjection(@PathVariable name:String):Response<List<CustomerProjection>>{
        return Response(status= ResponseStatus.SUCCESS , data=customerService.getCustomerDataByNameStartWith(name))
    }
}