package com.example.firstapi.entity

import javax.persistence.*

@Entity
@Table(name="AUTHER")
class Auther {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long?=null;
    var name:String?=null
    var nationalId:String?=null


}