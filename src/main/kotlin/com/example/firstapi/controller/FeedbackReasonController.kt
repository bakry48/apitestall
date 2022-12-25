package com.example.firstapi.controller

import com.example.firstapi.models.entity.FeedbackReasonCode
import com.example.firstapi.services.impl.FeedbackReasonCodeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/feedbackreason/")
class FeedbackReasonController {

    @Autowired
    private lateinit var feedbackReasonservice: FeedbackReasonCodeService

    @PostMapping("")
    fun addFeedBackReason(@RequestBody feedbackReasonCodeEntity: FeedbackReasonCode): FeedbackReasonCode {
       return feedbackReasonservice.saveOffer(feedbackReasonCodeEntity)

    }

    @PutMapping("")
    fun updateFeedBackReason(@RequestBody feedbackReasonCodeEntity: FeedbackReasonCode):String{

        return feedbackReasonservice.updateOffer(feedbackReasonCodeEntity)
    }
}