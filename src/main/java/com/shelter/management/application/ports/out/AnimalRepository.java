package main.java.com.shelter.management.application.ports.out;

import com.shelter.management.domain.entities.Animal;
import com.shelter.management.domain.enums.AnimalStatus;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository {
    Animal save(Animal animal);
    Optional<Animal> findById(Long id);
    List<Animal> findAll();
    List<Animal> findByCurrentStatus(AnimalStatus status);
    List<Animal> findByNameContainingIgnoreCase(String name);
    List<Animal> findBySpeciesIgnoreCase(String species);
    void deleteById(Long id);
    boolean existsById(Long id);
}
