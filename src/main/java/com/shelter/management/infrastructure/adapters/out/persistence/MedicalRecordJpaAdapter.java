package com.shelter.management.infrastructure.adapters.out.persistence;

import com.shelter.management.application.ports.out.MedicalRecordRepository;
import com.shelter.management.domain.entities.MedicalRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MedicalRecordJpaAdapter implements MedicalRecordRepository {

    private final SpringDataMedicalRecordRepository repository;

    @Override
    public MedicalRecord save(MedicalRecord medicalRecord) {
        return repository.save(medicalRecord);
    }

    @Override
    public Optional<MedicalRecord> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<MedicalRecord> findAll() {
        return repository.findAll();
    }

    @Override
    public List<MedicalRecord> findByAnimalId(Long animalId) {
        return repository.findByAnimalId(animalId);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
