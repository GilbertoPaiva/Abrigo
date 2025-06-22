package com.shelter.management.application.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalDTO {
    
    private Long id;
    private String name;
    private String species;
    private String breed;
    private Integer age;
    private Double weight;
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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
