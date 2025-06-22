package main.java.com.shelter.management.application.ports.out;

import com.shelter.management.domain.entities.Medication;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MedicationRepository {
    Medication save(Medication medication);
    Optional<Medication> findById(Long id);
    List<Medication> findAll();
    List<Medication> findByExpirationDateBefore(LocalDate date);
    List<Medication> findByStockQuantityLessThanMinimumStock();
    void deleteById(Long id);
}
