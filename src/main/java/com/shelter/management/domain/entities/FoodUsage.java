package com.shelter.management.domain.entities;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "food_usage")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodUsage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "food_id", nullable = false)
    private Long foodId;
    
    @Column(name = "animal_id")
    private Long animalId; // Pode ser null se for uso geral
    
    @Column(name = "quantity_used")
    private Double quantityUsed; // kg
    
    @Column(name = "usage_date", nullable = false)
    private LocalDate usageDate;
    
    @Column(name = "used_by")
    private String usedBy;
    
    @Column(columnDefinition = "TEXT")
    private String observations;
    
    // Relacionamentos
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id", insertable = false, updatable = false)
    private Food food;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id", insertable = false, updatable = false)
    private Animal animal;
}
