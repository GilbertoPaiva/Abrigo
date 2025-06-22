package main.java.com.shelter.management.application.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodDTO {
    
    private Long id;
    private String name;
    private String brand;
    private String targetAnimal;
    private String ageGroup;
    private String flavor;
    private Double packageWeight;
    private Integer stockQuantity;
    private LocalDate expirationDate;
    private String supplier;
    private BigDecimal unitPrice;
    private Integer minimumStock;
    private String nutritionalInfo;
    private String observations;
    private Boolean expired;
    private Boolean lowStock;
}
