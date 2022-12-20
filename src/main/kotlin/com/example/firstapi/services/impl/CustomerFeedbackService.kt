package com.example.firstapi.services.impl

import com.example.firstapi.entity.CustomerFeedback
import com.example.firstapi.entity.Offer
import com.example.firstapi.repository.IcustomerfeedBackrepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerFeedbackService {
    @Autowired
    private lateinit var icustomerfeedBackrepo: IcustomerfeedBackrepo

    fun thumpUp(customerFeedbackEntity: CustomerFeedback):String{
        icustomerfeedBackrepo.save(customerFeedbackEntity)
        return "feedBack Liked"
    }

    fun existBynationalIdAndOffer(nationalId : String , offer : Offer):Boolean{
        return icustomerfeedBackrepo.existsByNationalIdAndOffer(nationalId , offer)
    }

    fun getCustomerFeedBack():List<CustomerFeedback>{
       return icustomerfeedBackrepo.findAll()
    }

    fun findByOfferId(offerId : Long):List<CustomerFeedback>{
        return icustomerfeedBackrepo.findByOfferId(offerId)
    }


}