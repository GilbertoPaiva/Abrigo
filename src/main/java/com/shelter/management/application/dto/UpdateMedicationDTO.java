package main.java.com.shelter.management.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMedicationDTO {
    private String name;
    private String brand;
    private String activeIngredient;
    private String type;
    private String dosage;
    private String administration;
    private Integer stockQuantity;
    private LocalDate expirationDate;
    private String supplier;
    private BigDecimal unitPrice;
    private Integer minimumStock;
    private String observations;
}
