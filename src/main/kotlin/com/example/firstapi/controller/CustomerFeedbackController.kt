package com.example.firstapi.controller

import com.example.firstapi.models.entity.CustomerFeedback
import com.example.firstapi.models.entity.FeedbackReasonCode
import com.example.firstapi.models.entity.Offer
import com.example.firstapi.services.impl.CustomerFeedbackService
import com.example.firstapi.services.impl.FeedbackReasonCodeService
import com.example.firstapi.util.Response
import com.example.firstapi.util.ResponseStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/feedback")
class CustomerFeedbackController {
    @Autowired
    private lateinit var customerFeedbackService: CustomerFeedbackService
    @Autowired
    private lateinit var feedbackReasonCodeService: FeedbackReasonCodeService

    @PostMapping("/thumpup")
    fun thumpUp(@RequestBody customerFeedBackEntity : CustomerFeedback):String{
       return customerFeedbackService.thumpUp(customerFeedBackEntity)
    }
    @GetMapping("/{nationalId}/{offer}")
    fun existBynationalIdAndOffer(@PathVariable nationalId : String , offer : Offer):Boolean{
        return customerFeedbackService.existBynationalIdAndOffer(nationalId , offer)
    }
    @GetMapping("/getreasons")
    fun getReasons(): Response<List<FeedbackReasonCode>> {
        return Response(status = ResponseStatus.SUCCESS , data = feedbackReasonCodeService.getFeedback())
    }

    @GetMapping("")
    fun getCustomerFeedback(

    ):Response<List<CustomerFeedback>>{
        return Response(status = ResponseStatus.SUCCESS , data=customerFeedbackService.getCustomerFeedBack())
    }

    @GetMapping("/offerid/{offerId}")
    fun findByOfferId(@PathVariable offerId:Long):Response<List<CustomerFeedback>>{
      return  Response(status = ResponseStatus.SUCCESS , data = customerFeedbackService.findByOfferId(offerId))
    }



}