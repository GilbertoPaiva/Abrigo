package com.shelter.management.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalRecordDTO {
    private Long id;
    private Long animalId;
    private String animalName;
    private LocalDate treatmentDate;
    private String veterinarian;
    private String diagnosis;
    private String treatment;
    private String observations;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<MedicationUsageDTO> medicationsUsed;
}
