package com.Tayyab.Employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseEntity<?> handleEmployeeNotFoundException(EmployeeNotFound employee) {
        return new ResponseEntity<>(employee.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidAgeException.class)
    public ResponseEntity<?> handleInvalidAgeException(InvalidAgeException invalidAge) {
        return new ResponseEntity<>(invalidAge.getMessage(), HttpStatus.FORBIDDEN);
    }
}
