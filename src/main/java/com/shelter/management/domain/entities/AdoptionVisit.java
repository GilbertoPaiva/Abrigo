package main.java.com.shelter.management.domain.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "adoption_visits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdoptionVisit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "adoption_id", nullable = false)
    private Long adoptionId;
    
    @Column(name = "visit_date", nullable = false)
    private LocalDate visitDate;
    
    @Column(name = "visited_by")
    private String visitedBy;
    
    @Column(name = "animal_condition", columnDefinition = "TEXT")
    private String animalCondition;
    
    @Column(name = "environment_condition", columnDefinition = "TEXT")
    private String environmentCondition;
    
    private Boolean approved;
    
    @Column(columnDefinition = "TEXT")
    private String observations;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    // Relacionamentos
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adoption_id", insertable = false, updatable = false)
    private Adoption adoption;
}
