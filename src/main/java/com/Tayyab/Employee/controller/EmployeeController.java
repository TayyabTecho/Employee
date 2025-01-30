package com.Tayyab.Employee.controller;

import com.Tayyab.Employee.model.Employee;
import com.Tayyab.Employee.request.EmployeeRequest;
import com.Tayyab.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Retention;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public void postEmployee(@RequestBody EmployeeRequest employeeRequest) {
        employeeService.createEmployee(employeeRequest);
    }


    @GetMapping("/{employeeId}")

    public Employee getEmployee(@PathVariable Long employeeId) {
        return employeeService.findEmployeeById(employeeId);
    }


    @DeleteMapping("/{employeeId}")

    public void deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteById(employeeId);
    }

    @PutMapping("/")
    public String updateEmployee(@RequestBody EmployeeRequest employeeRequest, @PathVariable Long employeeId) {
        employeeService.updateEmployee(employeeId, employeeRequest);
        return "employee updated successfully";
    }
}
