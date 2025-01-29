package com.Tayyab.Employee.service;

import com.Tayyab.Employee.exception.EmployeeNotFound;
import com.Tayyab.Employee.exception.InvalidAgeException;
import com.Tayyab.Employee.model.Employee;
import com.Tayyab.Employee.repository.EmployeeRepository;
import com.Tayyab.Employee.request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public void createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employee.setEmployeeName(employeeRequest.getEmployeeName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setPassword(employeeRequest.getPassword());

        if (employeeRequest.getAge() <= 40 && employeeRequest.getAge() > 18) {
            employee.setAge(employeeRequest.getAge());
        }else{
            throw new InvalidAgeException("Age Not Valid");
        }

        employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long employeeId) {
        Employee e1 = employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFound("employeeId not found"));
        return e1;
//        return employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("employeeId not found"));

    }

    public void deleteById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
        // employeeRepository.delete(e2);
    }

    public String updateEmployee(Long employeeId, EmployeeRequest employeeRequest) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("employeeId not found"));


        employee.setEmployeeName(employeeRequest.getEmployeeName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setPassword(employeeRequest.getPassword());
        return "employee updated successfully";
    }
}
