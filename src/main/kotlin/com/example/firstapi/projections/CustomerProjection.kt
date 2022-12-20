package com.example.firstapi.projections

import org.springframework.beans.factory.annotation.Value

interface   CustomerProjection {
     fun getNationalId():String

     // if we show property with different name like User and pass the username into it
     @Value("#{target.user.username}")
     fun getUser():String

}