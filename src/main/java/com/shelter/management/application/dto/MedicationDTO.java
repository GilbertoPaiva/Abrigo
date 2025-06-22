package com.shelter.management.application.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicationDTO {
    
    private Long id;
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
    private Boolean expired;
    private Boolean lowStock;
}
