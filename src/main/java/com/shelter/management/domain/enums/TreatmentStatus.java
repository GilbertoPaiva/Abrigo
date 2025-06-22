package main.java.com.shelter.management.domain.enums;

import lombok.Getter;

@Getter
public enum TreatmentStatus {
    EM_ANDAMENTO("Em Andamento"),
    CONCLUIDO("Concluído"),
    SUSPENSO("Suspenso"),
    CANCELADO("Cancelado");

    private final String description;
    
    TreatmentStatus(String description) {
        this.description = description;
    }
}
