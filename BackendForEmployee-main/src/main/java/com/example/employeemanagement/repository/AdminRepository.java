package com.example.employeemanagement.repository;

import com.example.employeemanagement.domain.Admin;
import com.example.employeemanagement.domain.Employee;
import com.example.employeemanagement.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Long> {

    Admin findByUser(User user);
    List<Admin> findAllByUserId(Long id);
    List<Admin> findAll();
}
