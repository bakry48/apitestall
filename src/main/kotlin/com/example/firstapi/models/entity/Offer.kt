package com.example.firstapi.models.entity

import com.example.firstapi.models.enums.Status
import java.time.LocalDate
import javax.persistence.*



@Entity
@Table(name="OFFER")
class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = null
    open var offerNameEn:String?=null
    open var offerNameAr:String?=null

    open lateinit var titleAr: String
    open lateinit var titleEn: String
    open lateinit var subtitleAr: String
    open lateinit var subtitleEn: String
    open var descriptionAr: String? = ""
    open var descriptionEn: String? = ""
    open lateinit var startDate: LocalDate
    open lateinit var expiryDate: LocalDate
    open var webLink: String? = ""
    open var shopOnline: Boolean = false
    open var live: Boolean = false
    open var pinOrder: Int = 0
    open var storeLocation: String? = ""
    open var hasStoreLocation: Boolean = false
    open var defaultTemplate: Boolean? = false

    @Column(name = "STATUS", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    open lateinit var status: Status
/*
دي معناها انه هيربط الاوفر بعلاقه مع الكاستومر بس مش هيبقي ليها عمود ف داتا بيز الاوفر
عشان يبان الفيدباك مثلا عند استدعاء اي اوفر
    @OneToMany(mappedBy = "offer")
    open var customerfeedback:List<CustomerFeedback>?=null


 */
}