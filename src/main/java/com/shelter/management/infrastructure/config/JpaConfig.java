package com.shelter.management.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.shelter.management.infrastructure.adapters.out.persistence")
@EnableTransactionManagement
public class JpaConfig {
}
