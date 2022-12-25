package com.example.firstapi.models.entity

import javax.persistence.*

@Entity
@Table(name = "USER")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id:Long?=null
    open var username:String?=null
    open lateinit var password:String

//    @OneToOne(mappedBy = "user")
//    var customer:Customer?=null


}
