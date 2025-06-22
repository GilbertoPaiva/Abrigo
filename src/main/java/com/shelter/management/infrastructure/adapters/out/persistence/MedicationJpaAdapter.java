package com.shelter.management.infrastructure.adapters.out.persistence;

import com.shelter.management.application.ports.out.MedicationRepository;
import com.shelter.management.domain.entities.Medication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MedicationJpaAdapter implements MedicationRepository {

    private final SpringDataMedicationRepository repository;

    @Override
    public Medication save(Medication medication) {
        return repository.save(medication);
    }

    @Override
    public Optional<Medication> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Medication> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Medication> findByExpirationDateBefore(LocalDate date) {
        return repository.findByExpirationDateBefore(date);
    }

    @Override
    public List<Medication> findByStockQuantityLessThanMinimumStock() {
        return repository.findByStockQuantityLessThanMinimumStock();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
