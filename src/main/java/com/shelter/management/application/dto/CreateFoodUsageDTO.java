package main.java.com.shelter.management.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateFoodUsageDTO {
    @NotNull(message = "ID da ração é obrigatório")
    private Long foodId;
    
    private Long animalId; // Pode ser null se for uso geral
    
    @NotNull(message = "Quantidade usada é obrigatória")
    private Double quantityUsed;
    
    @NotNull(message = "Data de uso é obrigatória")
    private LocalDate usageDate;
    
    private String usedBy;
    private String observations;
}
