package com.example.firstapi.services.impl

import org.springframework.data.domain.AuditorAware
import java.util.*

class AuditorAwareImpl : AuditorAware<String>{
    override fun getCurrentAuditor(): Optional<String> {
       return Optional.of("ahmed bakry")
    }
}