package com.shelter.management.application.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateAnimalDTO {
    
    private String name;
    private String breed;
    private Integer age;
    private BigDecimal weight;
    private String size;
    private String color;
    private String observations;
    private Boolean microchipped;
    private String microchipNumber;
    private Boolean vaccinated;
    private Boolean sterilized;
}
