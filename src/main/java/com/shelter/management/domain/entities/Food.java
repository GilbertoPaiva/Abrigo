package main.java.com.shelter.management.domain.entities;

import com.shelter.management.domain.enums.AgeGroup;
import com.shelter.management.domain.enums.AnimalType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "foods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Food {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    private String brand;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "target_animal")
    private AnimalType targetAnimal;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "age_group")
    private AgeGroup ageGroup;
    
    private String flavor;
    
    @Column(name = "package_weight")
    private Double packageWeight; // kg
    
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
    
    @Column(name = "nutritional_info", columnDefinition = "TEXT")
    private String nutritionalInfo;
    
    @Column(columnDefinition = "TEXT")
    private String observations;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Relacionamentos
    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodUsage> usages;
}
