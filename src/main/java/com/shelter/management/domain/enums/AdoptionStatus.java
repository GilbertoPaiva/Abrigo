package com.shelter.management.domain.enums;

import lombok.Getter;

@Getter
public enum AdoptionStatus {
    PENDENTE("Pendente"),
    EM_ANALISE("Em Análise"),
    APROVADA("Aprovada"),
    REJEITADA("Rejeitada"),
    CANCELADA("Cancelada");

    private final String description;
    
    AdoptionStatus(String description) {
        this.description = description;
    }
}
