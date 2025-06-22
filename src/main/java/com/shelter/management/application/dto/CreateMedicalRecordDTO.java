package main.java.com.shelter.management.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMedicalRecordDTO {
    @NotNull(message = "ID do animal é obrigatório")
    private Long animalId;
    
    @NotNull(message = "Data do tratamento é obrigatória")
    private LocalDate treatmentDate;
    
    @NotBlank(message = "Nome do veterinário é obrigatório")
    private String veterinarian;
    
    @NotBlank(message = "Diagnóstico é obrigatório")
    private String diagnosis;
    
    @NotBlank(message = "Tratamento é obrigatório")
    private String treatment;
    
    private String observations;
    private String status;
}
