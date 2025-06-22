package main.java.com.shelter.management.infrastructure.adapters.out.persistence;

import com.shelter.management.application.ports.out.AnimalRepository;
import com.shelter.management.domain.entities.Animal;
import com.shelter.management.domain.enums.AnimalStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AnimalJpaAdapter implements AnimalRepository {

    private final SpringDataAnimalRepository springDataAnimalRepository;

    @Override
    public Animal save(Animal animal) {
        return springDataAnimalRepository.save(animal);
    }

    @Override
    public Optional<Animal> findById(Long id) {
        return springDataAnimalRepository.findById(id);
    }

    @Override
    public List<Animal> findAll() {
        return springDataAnimalRepository.findAll();
    }

    @Override
    public List<Animal> findByCurrentStatus(AnimalStatus status) {
        return springDataAnimalRepository.findByCurrentStatus(status);
    }

    @Override
    public List<Animal> findByNameContainingIgnoreCase(String name) {
        return springDataAnimalRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Animal> findBySpeciesIgnoreCase(String species) {
        return springDataAnimalRepository.findBySpeciesIgnoreCase(species);
    }

    @Override
    public void deleteById(Long id) {
        springDataAnimalRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return springDataAnimalRepository.existsById(id);
    }
}
