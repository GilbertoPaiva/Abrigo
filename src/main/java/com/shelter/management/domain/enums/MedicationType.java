package main.java.com.shelter.management.domain.enums;

import lombok.Getter;

@Getter
public enum MedicationType {
    ANTIBIOTICO("Antibiótico"),
    ANALGESICO("Analgésico"),
    ANTI_INFLAMATORIO("Anti-inflamatório"),
    VITAMINA("Vitamina"),
    VACINA("Vacina"),
    ANTIPARASITARIO("Antiparasitário"),
    SUPLEMENTO("Suplemento"),
    OUTROS("Outros");

    private final String description;
    
    MedicationType(String description) {
        this.description = description;
    }
}
