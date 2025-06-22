package com.shelter.management.infrastructure.adapters.out.persistence;

import com.shelter.management.domain.entities.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SpringDataMedicationRepository extends JpaRepository<Medication, Long> {
    
    List<Medication> findByExpirationDateBefore(LocalDate date);
    
    @Query("SELECT m FROM Medication m WHERE m.stockQuantity < m.minimumStock")
    List<Medication> findByStockQuantityLessThanMinimumStock();
}
