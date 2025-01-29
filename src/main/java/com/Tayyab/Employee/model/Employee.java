package com.Tayyab.Employee.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    private String employeeName;
    private String email;
    private String password;
    private int age;
}

