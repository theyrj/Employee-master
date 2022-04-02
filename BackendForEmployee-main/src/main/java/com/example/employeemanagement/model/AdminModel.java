package com.example.employeemanagement.model;

import com.example.employeemanagement.util.UserRole;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class AdminModel {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String designation;
    @Enumerated(EnumType.ORDINAL)
    private UserRole role;

}
