package com.Tayyab.Employee.exception;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice

public class ExceptionController {
    @ExceptionHandler(EmployeeNotFound.class)
@RequestBody
    public ResponseEntity<?> handleEmployeeNotFoundException(EmployeeNotFound employee) {
        return new ResponseEntity<>(employee.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidAgeException.class)
    @ResponseBody
    public ResponseEntity<?> handleInvalidAgeException(InvalidAgeException invalidAge) {
        return new ResponseEntity<>(invalidAge.getMessage(), HttpStatus.FORBIDDEN);
    }
}
