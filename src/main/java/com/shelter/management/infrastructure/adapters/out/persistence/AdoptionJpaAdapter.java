package com.shelter.management.infrastructure.adapters.out.persistence;

import com.shelter.management.application.ports.out.AdoptionRepository;
import com.shelter.management.domain.entities.Adoption;
import com.shelter.management.domain.enums.AdoptionStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AdoptionJpaAdapter implements AdoptionRepository {

    private final SpringDataAdoptionRepository repository;

    @Override
    public Adoption save(Adoption adoption) {
        return repository.save(adoption);
    }

    @Override
    public Optional<Adoption> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Adoption> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Adoption> findByStatus(AdoptionStatus status) {
        return repository.findByStatus(status);
    }

    @Override
    public List<Adoption> findByAnimalId(Long animalId) {
        return repository.findByAnimalId(animalId);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
