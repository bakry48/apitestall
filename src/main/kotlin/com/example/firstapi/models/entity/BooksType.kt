package com.example.firstapi.models.entity

import javax.persistence.*

@Entity
@Table(name="BOOKSTYPE")
class BooksType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    var id: Long?=null
    var type:String?=null


}