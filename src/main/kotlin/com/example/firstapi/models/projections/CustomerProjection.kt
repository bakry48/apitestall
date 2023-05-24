package com.example.firstapi.models.projections

import org.springframework.beans.factory.annotation.Value

interface   CustomerProjection {
     fun getNationalId():String

     // if we show property with different name like User and pass the username into it
     @Value("#{target.user.password}")
     fun getUser():String

}