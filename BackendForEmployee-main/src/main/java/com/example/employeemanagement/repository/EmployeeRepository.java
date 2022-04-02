package com.example.employeemanagement.repository;

import com.example.employeemanagement.domain.Employee;
import com.example.employeemanagement.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByUser(User user);
    Employee findAllByUserId(Long id);
    List<Employee> findAll();
}
