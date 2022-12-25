package com.example.firstapi.models.entity

import com.example.firstapi.models.enum.Publish
import com.fasterxml.jackson.annotation.JsonBackReference
import org.hibernate.annotations.Formula
import javax.persistence.*

@Entity
@Table(name="BOOKS")
class Books {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    var id: Long?=null
    var title: String?=null
    var price:Double?=null

    // add property not stored in database but show in endpoint
    @Transient
    var discount:Double?=null
    @JsonBackReference
    @ManyToOne(fetch= FetchType.LAZY , optional = false )
    @JoinColumn(name="AUTHER_ID" , nullable = false)
    var auther: Auther?=null

    @ManyToOne(fetch= FetchType.LAZY , optional = false )
    @JoinColumn(name="BOOKS_TYPE_ID")
    var bookType: BooksType?=null

    @Enumerated(EnumType.STRING)
    lateinit var publish : Publish

    @PostLoad
    fun calcDiscount(){
        this.discount=price?.times(0.1)
    }
}