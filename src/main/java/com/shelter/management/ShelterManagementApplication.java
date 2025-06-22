package com.shelter.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.shelter.management.infrastructure.adapters.repository")
public class ShelterManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShelterManagementApplication.class, args);
    }
}
