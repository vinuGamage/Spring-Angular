package com.spring.server.entity;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class EmployeeEntity {

    private long empId;
    private String name;
    private String email;

    public EmployeeEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    @Column(name = "name",nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email",nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
