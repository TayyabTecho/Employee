package com.Tayyab.Employee.exception;

public class EmployeeNameNotFound extends RuntimeException  {
    public EmployeeNameNotFound(String message) {
        super(message);
    }
}
