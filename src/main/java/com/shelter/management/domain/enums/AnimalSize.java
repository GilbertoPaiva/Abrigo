package com.shelter.management.domain.enums;

import lombok.Getter;

@Getter
public enum AnimalSize {
    PEQUENO("Pequeno"),
    MEDIO("Médio"),
    GRANDE("Grande"),
    GIGANTE("Gigante");

    private final String description;
    
    AnimalSize(String description) {
        this.description = description;
    }
}
