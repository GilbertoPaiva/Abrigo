package com.shelter.management.domain.enums;

import lombok.Getter;

@Getter
public enum Gender {
    MACHO("Macho"),
    FEMEA("Fêmea"),
    INDEFINIDO("Indefinido");

    private final String description;
    
    Gender(String description) {
        this.description = description;
    }
}
