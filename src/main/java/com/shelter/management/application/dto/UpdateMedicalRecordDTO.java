package main.java.com.shelter.management.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMedicalRecordDTO {
    private LocalDate treatmentDate;
    private String veterinarian;
    private String diagnosis;
    private String treatment;
    private String observations;
    private String status;
}
