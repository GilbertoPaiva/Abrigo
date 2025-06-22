package com.shelter.management.application.ports.out;

import com.shelter.management.domain.entities.Employee;
import com.shelter.management.domain.enums.EmployeeRole;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Employee save(Employee employee);
    Optional<Employee> findById(Long id);
    List<Employee> findAll();
    List<Employee> findByRole(EmployeeRole role);
    List<Employee> findByActiveTrue();
    Optional<Employee> findByEmail(String email);
    Optional<Employee> findByDocument(String document);
    void deleteById(Long id);
}
