package com.shelter.management.infrastructure.adapters.out.persistence;

import com.shelter.management.application.ports.out.AnimalStatusHistoryRepository;
import com.shelter.management.domain.entities.AnimalStatusHistory;
import com.shelter.management.domain.enums.AnimalStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AnimalStatusHistoryJpaAdapter implements AnimalStatusHistoryRepository {

    private final SpringDataAnimalStatusHistoryRepository repository;

    @Override
    public AnimalStatusHistory save(AnimalStatusHistory statusHistory) {
        return repository.save(statusHistory);
    }

    @Override
    public Optional<AnimalStatusHistory> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AnimalStatusHistory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<AnimalStatusHistory> findByAnimalId(Long animalId) {
        return repository.findByAnimalId(animalId);
    }

    @Override
    public List<AnimalStatusHistory> findByAnimalIdOrderByChangeDateDesc(Long animalId) {
        return repository.findByAnimalIdOrderByChangeDateDesc(animalId);
    }

    @Override
    public List<AnimalStatusHistory> findByNewStatus(AnimalStatus status) {
        return repository.findByNewStatus(status);
    }

    @Override
    public List<AnimalStatusHistory> findByChangeDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return repository.findByChangeDateBetween(startDate, endDate);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
