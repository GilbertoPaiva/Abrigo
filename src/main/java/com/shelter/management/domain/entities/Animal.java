package com.shelter.management.domain.entities;

import com.shelter.management.domain.enums.AnimalSize;
import com.shelter.management.domain.enums.AnimalStatus;
import com.shelter.management.domain.enums.Gender;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "animals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Animal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String species;
    
    private String breed;
    
    private Integer age; // Em meses
    
    private Double weight; // Em kg
    
    @Enumerated(EnumType.STRING)
    private AnimalSize size;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    private String color;
    
    private String foundLocation;
    
    private LocalDate rescueDate;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "current_status")
    private AnimalStatus currentStatus;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "arrival_status")
    private AnimalStatus arrivalStatus;
    
    @Column(columnDefinition = "TEXT")
    private String observations;
    
    @Column(name = "microchipped")
    @Builder.Default
    private Boolean microchipped = false;
    
    @Column(name = "microchip_number")
    private String microchipNumber;
    
    @Column(name = "vaccinated")
    @Builder.Default
    private Boolean vaccinated = false;
    
    @Column(name = "sterilized")
    @Builder.Default
    private Boolean sterilized = false;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Relacionamentos
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicalRecord> medicalRecords;
    
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Adoption> adoptions;
    
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnimalStatusHistory> statusHistory;
    
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodUsage> foodUsages;
}
