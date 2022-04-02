package com.example.employeemanagement.repository;

import com.example.employeemanagement.domain.User;
import com.example.employeemanagement.util.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);

    Optional<User> findById(Long id);

    Optional<User> findByRole(UserRole role);

}
