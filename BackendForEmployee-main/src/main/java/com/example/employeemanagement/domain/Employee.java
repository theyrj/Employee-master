package com.example.employeemanagement.domain;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Long salary;
    private String assigned;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Employee() {
    }

    public Employee(Long salary, String assigned) {
        this.salary = salary;
        this.assigned = assigned;
    }
}
