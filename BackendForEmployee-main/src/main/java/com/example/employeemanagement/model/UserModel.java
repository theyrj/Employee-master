package com.example.employeemanagement.model;

import com.example.employeemanagement.domain.Admin;
import com.example.employeemanagement.domain.Employee;
import com.example.employeemanagement.util.UserRole;
import lombok.Data;

@Data
public class UserModel {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserRole role;
    private Admin admin;
    private Employee employee;


}
