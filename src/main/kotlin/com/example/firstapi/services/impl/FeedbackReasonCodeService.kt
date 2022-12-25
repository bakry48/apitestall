package com.example.firstapi.services.impl

import com.example.firstapi.models.entity.FeedbackReasonCode
import com.example.firstapi.repository.IFeedbackReasonCode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class FeedbackReasonCodeService {

    @Autowired
    private lateinit var iFeedbackReasonCode: IFeedbackReasonCode

    fun saveOffer(feedbackEntity: FeedbackReasonCode): FeedbackReasonCode {

        iFeedbackReasonCode.save(feedbackEntity)
        iFeedbackReasonCode.flush()
        return iFeedbackReasonCode.findById(feedbackEntity.id!!).get()
    }

    /* fun saveOffer(feedbackEntity : FeedbackReasonCode):String{

        iFeedbackReasonCode.save(feedbackEntity)
        return "Your Feedback Inserted"
    }
*/
    fun getFeedback(): List<FeedbackReasonCode> {
        return iFeedbackReasonCode.findAll()
    }

    fun updateOffer(feedbackReasonCodeEntity: FeedbackReasonCode): String {
        var current: Optional<FeedbackReasonCode> = iFeedbackReasonCode.findById(feedbackReasonCodeEntity.id!!)
        var offeren = current.get()
        //offeren.reasonAr=feedbackReasonCodeEntity.reasonAr
        //iFeedbackReasonCode.save(offeren)
        iFeedbackReasonCode.save(feedbackReasonCodeEntity)
        iFeedbackReasonCode.flush()
        return "Your Feedback  Updated ${offeren.reasonAr}"
    }

}