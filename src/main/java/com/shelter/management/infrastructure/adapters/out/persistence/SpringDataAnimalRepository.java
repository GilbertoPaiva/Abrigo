package com.shelter.management.infrastructure.adapters.out.persistence;

import com.shelter.management.domain.entities.Animal;
import com.shelter.management.domain.enums.AnimalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataAnimalRepository extends JpaRepository<Animal, Long> {
    
    List<Animal> findByCurrentStatus(AnimalStatus status);
    
    List<Animal> findByNameContainingIgnoreCase(String name);
    
    List<Animal> findBySpeciesIgnoreCase(String species);
}
