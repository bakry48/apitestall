package com.example.firstapi.models.entity

import com.example.firstapi.models.enums.ReasonType
import javax.persistence.*
@Entity
@Table(name="FEEDBACK_REASON_CODE")
class FeedbackReasonCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = null
    open var reasonAr:String?=null
    open var reasonEn:String?=null
    open var status:Boolean?=null

    @Enumerated(EnumType.STRING)
    open var reasonType: ReasonType?=null

}