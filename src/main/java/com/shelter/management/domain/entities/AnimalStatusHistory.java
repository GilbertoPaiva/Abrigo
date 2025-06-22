package com.shelter.management.domain.entities;

import com.shelter.management.domain.enums.AnimalStatus;
import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "animal_status_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalStatusHistory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "animal_id", nullable = false)
    private Long animalId;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "previous_status")
    private AnimalStatus previousStatus;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "new_status", nullable = false)
    private AnimalStatus newStatus;
    
    @Column(name = "change_date", nullable = false)
    private LocalDateTime changeDate;
    
    @Column(name = "changed_by")
    private String changedBy;
    
    @Column(columnDefinition = "TEXT")
    private String reason;
    
    @Column(columnDefinition = "TEXT")
    private String observations;
    
    // Relacionamentos
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id", insertable = false, updatable = false)
    private Animal animal;
}
