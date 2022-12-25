package com.example.firstapi.repository

import com.example.firstapi.models.entity.FeedbackReasonCode
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface IFeedbackReasonCode : JpaRepository<FeedbackReasonCode, Long> {

    @Query(value = "select reasons from  FeedbackReasonCode reasons where reasons.status = true  ")
    override fun findAll() : List<FeedbackReasonCode>
}