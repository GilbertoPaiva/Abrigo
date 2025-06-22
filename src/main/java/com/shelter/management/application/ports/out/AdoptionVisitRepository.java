package main.java.com.shelter.management.application.ports.out;

import com.shelter.management.domain.entities.AdoptionVisit;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AdoptionVisitRepository {
    AdoptionVisit save(AdoptionVisit adoptionVisit);
    Optional<AdoptionVisit> findById(Long id);
    List<AdoptionVisit> findAll();
    List<AdoptionVisit> findByAdoptionId(Long adoptionId);
    List<AdoptionVisit> findByVisitDateBetween(LocalDate startDate, LocalDate endDate);
    List<AdoptionVisit> findByApprovedTrue();
    List<AdoptionVisit> findByApprovedFalse();
    void deleteById(Long id);
}
