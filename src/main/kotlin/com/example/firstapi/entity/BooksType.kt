package com.example.firstapi.entity

import javax.persistence.*

@Entity
@Table(name="BOOKSTYPE")
class BooksType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    var id: Long?=null
    var type:String?=null

    @OneToMany
    @JoinColumn(name = "BOOKS_ID")
    lateinit var book : List<Books>
}