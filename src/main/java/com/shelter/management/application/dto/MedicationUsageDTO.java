package main.java.com.shelter.management.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicationUsageDTO {
    private Long id;
    private Long medicalRecordId;
    private Long medicationId;
    private String medicationName;
    private Integer quantityUsed;
    private String dosageAdministered;
    private LocalDateTime administrationDate;
    private String administeredBy;
    private String observations;
}
