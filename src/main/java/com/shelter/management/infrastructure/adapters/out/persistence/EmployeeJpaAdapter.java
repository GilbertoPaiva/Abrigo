package com.shelter.management.infrastructure.adapters.out.persistence;

import com.shelter.management.application.ports.out.EmployeeRepository;
import com.shelter.management.domain.entities.Employee;
import com.shelter.management.domain.enums.EmployeeRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EmployeeJpaAdapter implements EmployeeRepository {

    private final SpringDataEmployeeRepository repository;

    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Employee> findByRole(EmployeeRole role) {
        return repository.findByRole(role);
    }

    @Override
    public List<Employee> findByActiveTrue() {
        return repository.findByActiveTrue();
    }

    @Override
    public Optional<Employee> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Optional<Employee> findByDocument(String document) {
        return repository.findByDocument(document);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
