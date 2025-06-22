package main.java.com.shelter.management.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAdoptionDTO {
    @NotNull(message = "ID do animal é obrigatório")
    private Long animalId;
    
    @NotBlank(message = "Nome do adotante é obrigatório")
    private String adopterName;
    
    @Email(message = "Email deve ser válido")
    private String adopterEmail;
    
    @NotBlank(message = "Telefone é obrigatório")
    private String adopterPhone;
    
    @NotBlank(message = "Endereço é obrigatório")
    private String adopterAddress;
    
    @NotBlank(message = "Documento é obrigatório")
    private String adopterDocument;
    
    private LocalDate adoptionDate;
    private String observations;
}
