package com.example.firstapi.services.impl

import com.example.firstapi.entity.Auther
import com.example.firstapi.repository.IAutherRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AutherService {

    @Autowired
    final lateinit var iAutherRepository: IAutherRepository

    fun autherSave(autherEntity: Auther):Auther{
        iAutherRepository.save(autherEntity)

        return iAutherRepository.findById(autherEntity.id!!).get()
    }
}