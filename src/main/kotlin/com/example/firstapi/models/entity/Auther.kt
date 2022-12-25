package com.example.firstapi.models.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import org.hibernate.annotations.Formula
import javax.persistence.*
import javax.validation.constraints.Email


import javax.validation.constraints.Pattern
@Entity
@Table(name="AUTHER")
class Auther : Auditable<String>() {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long?=null;
    var name:String?=null

    var nationalId:String?=null
    @Email(message = "not email")
    var email:String?=null
    @Pattern(regexp = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$" , message = "not ip address")
    var ipAddress:String?=null

  //  @Formula("(select  count(*) from books book where book.auther_id=id )")
  //  var bookCount:Long?=null
    @JsonManagedReference
    @OneToMany(mappedBy = "auther")
    open var books:List<Books>?=null

}