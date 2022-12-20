package com.example.firstapi.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "CUSTOMER")
class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id:Long?=null
    open var name:String?=null
    open var nationalId:String?=null
    @OneToOne(fetch= FetchType.LAZY , optional = false , cascade = [CascadeType.ALL])
    @JoinColumn(name="USER_ID" , nullable = true)

    open var user: User?=null

}