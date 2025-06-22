package com.shelter.management.domain.entities;

import com.shelter.management.domain.enums.MedicationType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "medications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medication {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    private String brand;
    
    @Column(name = "active_ingredient")
    private String activeIngredient;
    
    @Enumerated(EnumType.STRING)
    private MedicationType type;
    
    private String dosage;
    
    private String administration;
    
    @Column(name = "stock_quantity")
    @Builder.Default
    private Integer stockQuantity = 0;
    
    @Column(name = "expiration_date")
    private LocalDate expirationDate;
    
    private String supplier;
    
    @Column(name = "unit_price", precision = 10, scale = 2)
    private BigDecimal unitPrice;
    
    @Column(name = "minimum_stock")
    @Builder.Default
    private Integer minimumStock = 0;
    
    @Column(columnDefinition = "TEXT")
    private String observations;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Relacionamentos
    @OneToMany(mappedBy = "medication", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicationUsage> usages;
}
