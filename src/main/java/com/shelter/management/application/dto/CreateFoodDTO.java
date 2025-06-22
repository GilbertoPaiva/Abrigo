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
public class CreateFoodDTO {
    @NotBlank(message = "Nome da ração é obrigatório")
    private String name;
    
    @NotBlank(message = "Marca é obrigatória")
    private String brand;
    
    private String targetAnimal;
    private String ageGroup;
    private String flavor;
    
    @NotNull(message = "Peso da embalagem é obrigatório")
    private Double packageWeight;
    
    @NotNull(message = "Quantidade em estoque é obrigatória")
    private Integer stockQuantity;
    
    private LocalDate expirationDate;
    private String supplier;
    private BigDecimal unitPrice;
    private Integer minimumStock;
    private String nutritionalInfo;
    private String observations;
}
