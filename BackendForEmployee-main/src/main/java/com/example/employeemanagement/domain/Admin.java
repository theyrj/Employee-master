package com.example.employeemanagement.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String designation;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public Admin() {
    }

    public Admin(String designation) {
        this.designation = designation;
    }
}
