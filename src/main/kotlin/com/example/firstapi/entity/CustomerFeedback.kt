package com.example.firstapi.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name="CUSTOMER_FEEDBACK")
class CustomerFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = null
    open lateinit var nationalId:String
    open var usefull:Boolean?=null
    open var otherFeedback:String?=null

    @ManyToOne(fetch= FetchType.LAZY , optional = false)
    @JoinColumn(name="OFFER_ID" , nullable = false)
    //@JsonIgnore  معناها انه هيهمل القيمه دي لما اجي انادي علي الكلاس من بوست مان
    open var offer: Offer?=null

    @ManyToOne(fetch= FetchType.LAZY , optional = true)
    @JoinColumn(name="FEEDBACK_REASON_CODE_ID" , nullable = true)
    open var reason: FeedbackReasonCode?=null
}