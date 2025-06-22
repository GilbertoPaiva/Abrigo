package main.java.com.shelter.management.domain.entities;

import com.shelter.management.domain.enums.EmployeeRole;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    private String phone;
    
    @Column(unique = true)
    private String document; // CPF
    
    @Column(columnDefinition = "TEXT")
    private String address;
    
    @Enumerated(EnumType.STRING)
    private EmployeeRole role;
    
    @Column(name = "hire_date")
    private LocalDate hireDate;
    
    @Column(nullable = false)
    @Builder.Default
    private Boolean active = true;
    
    @Column(columnDefinition = "TEXT")
    private String observations;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
