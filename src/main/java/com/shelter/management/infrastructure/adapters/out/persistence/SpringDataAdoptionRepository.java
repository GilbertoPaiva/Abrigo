package com.shelter.management.infrastructure.adapters.out.persistence;

import com.shelter.management.domain.entities.Adoption;
import com.shelter.management.domain.enums.AdoptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataAdoptionRepository extends JpaRepository<Adoption, Long> {
    
    List<Adoption> findByStatus(AdoptionStatus status);
    
    List<Adoption> findByAnimalId(Long animalId);
}
