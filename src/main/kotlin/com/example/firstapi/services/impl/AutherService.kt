package com.example.firstapi.services.impl

import com.example.firstapi.mapper.AutherMapper
import com.example.firstapi.models.dto.AutherDto
import com.example.firstapi.models.entity.Auther
import com.example.firstapi.repository.IAutherRepository
import com.example.firstapi.util.Response
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class AutherService {


    @Autowired
    final lateinit var iAutherRepository: IAutherRepository

    val autherMapper = Mappers.getMapper(AutherMapper::class.java)

    fun autherSave(autherDto: AutherDto): Auther {
        var autherEntity= autherMapper.toAuther(autherDto)
        iAutherRepository.save(autherEntity)
        return iAutherRepository.findById(autherEntity.id!!).get()
    }

   fun getAllAuther():List<Auther>{
       return iAutherRepository.findAll()
   }

    fun getAuthorById(id: Long): Optional<Auther> {

        return iAutherRepository.findById(id)
    }
}