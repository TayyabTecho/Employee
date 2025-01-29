package com.Tayyab.Employee.request;

import lombok.Data;

@Data
public class EmployeeRequest {
    private String employeeName;
    private String email;
    private String password;
    private int age;
}