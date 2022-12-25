package com.example.firstapi.models.entity

import javax.persistence.*



@Entity
@Table(name="OFFER")
class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = null
    open var offerNameEn:String?=null
    open var OfferNameAr:String?=null
/*
دي معناها انه هيربط الاوفر بعلاقه مع الكاستومر بس مش هيبقي ليها عمود ف داتا بيز الاوفر
عشان يبان الفيدباك مثلا عند استدعاء اي اوفر
    @OneToMany(mappedBy = "offer")
    open var customerfeedback:List<CustomerFeedback>?=null


 */
}