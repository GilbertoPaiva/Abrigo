package com.shelter.management.infrastructure.adapters.out.persistence;

import com.shelter.management.application.ports.out.AdoptionVisitRepository;
import com.shelter.management.domain.entities.AdoptionVisit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AdoptionVisitJpaAdapter implements AdoptionVisitRepository {

    private final SpringDataAdoptionVisitRepository repository;

    @Override
    public AdoptionVisit save(AdoptionVisit adoptionVisit) {
        return repository.save(adoptionVisit);
    }

    @Override
    public Optional<AdoptionVisit> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AdoptionVisit> findAll() {
        return repository.findAll();
    }

    @Override
    public List<AdoptionVisit> findByAdoptionId(Long adoptionId) {
        return repository.findByAdoptionId(adoptionId);
    }

    @Override
    public List<AdoptionVisit> findByVisitDateBetween(LocalDate startDate, LocalDate endDate) {
        return repository.findByVisitDateBetween(startDate, endDate);
    }

    @Override
    public List<AdoptionVisit> findByApprovedTrue() {
        return repository.findByApprovedTrue();
    }

    @Override
    public List<AdoptionVisit> findByApprovedFalse() {
        return repository.findByApprovedFalse();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
