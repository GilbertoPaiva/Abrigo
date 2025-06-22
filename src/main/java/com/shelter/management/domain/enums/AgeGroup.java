package com.shelter.management.domain.enums;

import lombok.Getter;

@Getter
public enum AgeGroup {
    FILHOTE("Filhote"),
    ADULTO("Adulto"),
    SENIOR("Senior");

    private final String description;
    
    AgeGroup(String description) {
        this.description = description;
    }
}
