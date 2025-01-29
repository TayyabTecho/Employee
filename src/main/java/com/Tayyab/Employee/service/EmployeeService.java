package com.Tayyab.Employee.service;

import com.Tayyab.Employee.exception.EmployeeNotFound;
import com.Tayyab.Employee.exception.InvalidAgeException;
import com.Tayyab.Employee.model.Employee;
import com.Tayyab.Employee.repository.EmployeeRepository;
import com.Tayyab.Employee.request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employee.setEmployeeName(employeeRequest.getEmployeeName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setPassword(employeeRequest.getPassword());

        if (employeeRequest.getAge() <= 40 && employeeRequest.getAge() > 18) {
            employee.setAge(employeeRequest.getAge());
        } else {
            throw new InvalidAgeException("Age is Not Valid");
        }
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFound("employeeId not found"));
    }

    public Employee deleteById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee Id not Found for Delete user"));
        employeeRepository.deleteById(employeeId);
        return employee;
    }

    public Employee updateEmployeeById(Long employeeId, EmployeeRequest employeeRequest) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("employeeId not found"));
        if (employeeRequest.getEmployeeName() != null) {
            employee.setEmployeeName(employeeRequest.getEmployeeName());
        }
        if (employeeRequest.getEmail() != null) {
            employee.setEmail(employeeRequest.getEmail());
        }
        if (employeeRequest.getPassword() != null) {
            employee.setPassword(employeeRequest.getPassword());
        }
        employee.setAge(employeeRequest.getAge());
        employeeRepository.save(employee);
        return employee;
    }

    public List<Employee> deleteAllEmployee() {
      List<Employee> deletedEmployee = employeeRepository.findAll();
        employeeRepository.deleteAll();
        return deletedEmployee;
    }
}
