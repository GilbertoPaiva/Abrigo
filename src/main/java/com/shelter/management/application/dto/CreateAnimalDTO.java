package com.shelter.management.application.dto;

import lombok.*;

import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAnimalDTO {
    
    @NotBlank(message = "Nome é obrigatório")
    private String name;
    
    @NotBlank(message = "Espécie é obrigatória")
    private String species;
    
    private String breed;
    private Integer age;
    private BigDecimal weight;
    private String size;
    private String gender;
    private String color;
    private String foundLocation;
    private LocalDate rescueDate;
    private String currentStatus;
    private String arrivalStatus;
    private String observations;
    private Boolean microchipped;
    private String microchipNumber;
    private Boolean vaccinated;
    private Boolean sterilized;
}
