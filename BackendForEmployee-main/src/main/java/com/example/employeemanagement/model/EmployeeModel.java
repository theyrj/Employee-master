package com.example.employeemanagement.model;

import com.example.employeemanagement.domain.Employee;
import com.example.employeemanagement.domain.User;
import com.example.employeemanagement.util.UserRole;
import lombok.Data;

import javax.persistence.*;

@Data
public class EmployeeModel {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Long salary;
    private String assigned;
    @Enumerated(EnumType.ORDINAL)
    private UserRole role;


    public void getModel(User user , Employee employee){
        this.id = employee.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.salary = employee.getSalary();
        this.assigned = employee.getAssigned();
        this.role = user.getRole();
    }
}
