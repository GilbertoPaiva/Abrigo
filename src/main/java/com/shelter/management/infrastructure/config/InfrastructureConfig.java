package com.shelter.management.infrastructure.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
    "com.shelter.management.infrastructure.adapters.repository"
})
public class InfrastructureConfig {
    // Esta classe de configuração garante que todos os adaptadores de repositório sejam escaneados
}
