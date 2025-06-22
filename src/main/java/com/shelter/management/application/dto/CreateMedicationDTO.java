package main.java.com.shelter.management.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMedicationDTO {
    @NotBlank(message = "Nome do medicamento é obrigatório")
    private String name;
    
    @NotBlank(message = "Marca é obrigatória")
    private String brand;
    
    private String activeIngredient;
    private String type;
    private String dosage;
    private String administration;
    
    @NotNull(message = "Quantidade em estoque é obrigatória")
    private Integer stockQuantity;
    
    private LocalDate expirationDate;
    private String supplier;
    private BigDecimal unitPrice;
    private Integer minimumStock;
    private String observations;
}
