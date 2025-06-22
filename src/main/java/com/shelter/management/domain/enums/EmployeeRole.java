package com.shelter.management.domain.enums;

import lombok.Getter;

@Getter
public enum EmployeeRole {
    ADMIN("Administrador"),
    VETERINARIO("Veterinário"),
    CUIDADOR("Cuidador"),
    VOLUNTARIO("Voluntário");

    private final String description;
    
    EmployeeRole(String description) {
        this.description = description;
    }
}
