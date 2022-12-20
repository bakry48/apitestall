package com.example.firstapi.entity

import com.example.firstapi.entity.enum.Publish
import javax.persistence.*

@Entity
@Table(name="BOOKS")
class Books {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    var id: Long?=null
    var title: String?=null
    var price:Double?=null

    @ManyToOne
    @JoinColumn(name="AUTHER_ID")
    var auther:Auther?=null

    @Enumerated(EnumType.STRING)
    lateinit var publish : Publish
}