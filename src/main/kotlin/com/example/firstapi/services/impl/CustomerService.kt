package com.example.firstapi.services.impl

import com.example.firstapi.entity.Customer
import com.example.firstapi.entity.CustomerFeedback
import com.example.firstapi.entity.Offer
import com.example.firstapi.projections.CustomerProjection
import com.example.firstapi.repository.IcustomerRepo
import com.example.firstapi.repository.IcustomerfeedBackrepo
import com.example.firstapi.util.Response
import com.example.firstapi.util.ResponseStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService {
    @Autowired
    private lateinit var icustomerrepo: IcustomerRepo

    fun getCustomerByNameAndPassword(empName:String , pass:String):List<Customer>{
       return icustomerrepo.findByNameContainingAndUserPassword(empName , pass )
    }
    fun addCustomer(customerEntity: Customer):Response<String>{
        icustomerrepo.save(customerEntity)
       return Response(status = ResponseStatus.SUCCESS , data = "Customer Added Successfully")
    }

    fun getCustomers():Response<List<Customer>>{
       return Response(status = ResponseStatus.SUCCESS , data = icustomerrepo.findAll())
    }

    // to get data from projections
    fun getCustomerDataByNameStartWith(nameStartWith:String):List<CustomerProjection>{
        return icustomerrepo.findFirstByNameStartingWith(nameStartWith)
    }
}