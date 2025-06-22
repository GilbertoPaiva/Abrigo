package com.shelter.management.application.ports.out;

import com.shelter.management.domain.entities.Adoption;
import com.shelter.management.domain.enums.AdoptionStatus;

import java.util.List;
import java.util.Optional;

public interface AdoptionRepository {
    Adoption save(Adoption adoption);
    Optional<Adoption> findById(Long id);
    List<Adoption> findAll();
    List<Adoption> findByStatus(AdoptionStatus status);
    List<Adoption> findByAnimalId(Long animalId);
    void deleteById(Long id);
}
