package com.shelter.management.domain.enums;

import lombok.Getter;

@Getter
public enum AnimalStatus {
    DISPONIVEL_ADOCAO("Disponível para Adoção"),
    EM_TRATAMENTO("Em Tratamento"),
    QUARENTENA("Em Quarentena"),
    ADOTADO("Adotado"),
    OBITO("Óbito"),
    TRANSFERIDO("Transferido"),
    FUGIU("Fugiu");

    private final String description;
    
    AnimalStatus(String description) {
        this.description = description;
    }
}
