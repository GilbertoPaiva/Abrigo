package com.shelter.management.domain.enums;

import lombok.Getter;

@Getter
public enum AnimalType {
    CACHORRO("Cachorro"),
    GATO("Gato"),
    OUTROS("Outros");

    private final String description;
    
    AnimalType(String description) {
        this.description = description;
    }
}
