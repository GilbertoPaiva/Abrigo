package com.shelter.management.domain.entities;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "medication_usage")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicationUsage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "medical_record_id", nullable = false)
    private Long medicalRecordId;
    
    @Column(name = "medication_id", nullable = false)
    private Long medicationId;
    
    @Column(name = "quantity_used")
    private Integer quantityUsed;
    
    @Column(name = "dosage_administered")
    private String dosageAdministered;
    
    @Column(name = "administration_date")
    private LocalDateTime administrationDate;
    
    @Column(name = "administered_by")
    private String administeredBy;
    
    @Column(columnDefinition = "TEXT")
    private String observations;
    
    // Relacionamentos
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_record_id", insertable = false, updatable = false)
    private MedicalRecord medicalRecord;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medication_id", insertable = false, updatable = false)
    private Medication medication;
}
