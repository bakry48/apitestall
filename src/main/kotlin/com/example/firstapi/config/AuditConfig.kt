package com.example.firstapi.config

import com.example.firstapi.services.impl.AuditorAwareImpl
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.context.annotation.Bean
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
class AuditConfig {

    @Bean
    public fun auditorAware() : AuditorAware<String>{
         return AuditorAwareImpl()
    }
}