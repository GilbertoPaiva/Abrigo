package com.shelter.management.infrastructure.adapters.out.persistence;

import com.shelter.management.domain.entities.Employee;
import com.shelter.management.domain.enums.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpringDataEmployeeRepository extends JpaRepository<Employee, Long> {
    
    List<Employee> findByRole(EmployeeRole role);
    
    List<Employee> findByActiveTrue();
    
    Optional<Employee> findByEmail(String email);
    
    Optional<Employee> findByDocument(String document);
}
