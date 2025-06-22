package com.shelter.management.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAdoptionDTO {
    private String adopterName;
    private String adopterEmail;
    private String adopterPhone;
    private String adopterAddress;
    private String adopterDocument;
    private LocalDate adoptionDate;
    private String observations;
}
