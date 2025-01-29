package com.Tayyab.Employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidAgeException extends RuntimeException {
  public InvalidAgeException(String message) {
    super(message);
  }
}
