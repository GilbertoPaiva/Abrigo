package com.shelter.management.infrastructure.adapters.out.persistence;

import com.shelter.management.domain.entities.AdoptionVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SpringDataAdoptionVisitRepository extends JpaRepository<AdoptionVisit, Long> {
    
    List<AdoptionVisit> findByAdoptionId(Long adoptionId);
    
    List<AdoptionVisit> findByVisitDateBetween(LocalDate startDate, LocalDate endDate);
    
    List<AdoptionVisit> findByApprovedTrue();
    
    List<AdoptionVisit> findByApprovedFalse();
}
