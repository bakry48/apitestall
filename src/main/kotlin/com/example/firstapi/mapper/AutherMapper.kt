package com.example.firstapi.mapper

import com.example.firstapi.models.dto.AutherDto
import com.example.firstapi.models.entity.Auther
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
abstract class AutherMapper {

    abstract fun toAutherDto(authorEntity : Auther) :AutherDto

    abstract fun toAuther(autherDto: AutherDto) : Auther
}