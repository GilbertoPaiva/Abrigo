package com.shelter.management.domain.entities;

import com.shelter.management.domain.enums.AdoptionStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "adoptions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Adoption {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "animal_id", nullable = false)
    private Long animalId;
    
    @Column(name = "adopter_name", nullable = false)
    private String adopterName;
    
    @Column(name = "adopter_email")
    private String adopterEmail;
    
    @Column(name = "adopter_phone")
    private String adopterPhone;
    
    @Column(name = "adopter_address", columnDefinition = "TEXT")
    private String adopterAddress;
    
    @Column(name = "adopter_document")
    private String adopterDocument; // CPF
    
    @Column(name = "adoption_date")
    private LocalDate adoptionDate;
    
    @Enumerated(EnumType.STRING)
    private AdoptionStatus status;
    
    @Column(columnDefinition = "TEXT")
    private String observations;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Relacionamentos
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id", insertable = false, updatable = false)
    private Animal animal;
    
    @OneToMany(mappedBy = "adoption", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AdoptionVisit> visits;
}
