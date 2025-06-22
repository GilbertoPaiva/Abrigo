package main.java.com.shelter.management.application.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdoptionDTO {
    
    private Long id;
    private Long animalId;
    private String animalName;
    private String adopterName;
    private String adopterEmail;
    private String adopterPhone;
    private String adopterAddress;
    private String adopterDocument;
    private LocalDate adoptionDate;
    private String status;
    private String observations;
}
