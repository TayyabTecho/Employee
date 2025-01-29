package com.Tayyab.Employee.controller;

import com.Tayyab.Employee.exception.EmployeeNotFound;
import com.Tayyab.Employee.model.Employee;
import com.Tayyab.Employee.request.EmployeeRequest;
import com.Tayyab.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public ResponseEntity<?> registerEmployee(@RequestBody EmployeeRequest employeeRequest) {
        Employee employee = employeeService.createEmployee(employeeRequest);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        if (employee == null) {
            throw new EmployeeNotFound("Employee not found!");
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body("userFound Successfully");
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployee() {
        List<Employee> allEmployee = employeeService.findAllEmployee();
        if (allEmployee != null && !allEmployee.isEmpty()) {
            return new ResponseEntity<>(allEmployee, HttpStatus.OK);
        }
        throw new EmployeeNotFound("Employee not Found");
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllEmployee() {
        List<Employee> deletedlist = employeeService.deleteAllEmployee();
        if (deletedlist != null && !deletedlist.isEmpty()) {
            return new ResponseEntity<>(deletedlist, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Now the Database is Empty");
    }

    @PutMapping("/{myId}")
    public String updateEmployeeById(@RequestBody EmployeeRequest employeeRequest, @PathVariable Long myId){
        employeeService.updateEmployeeById(myId, employeeRequest);
        return "Employee Updated Successfully";
    }
}





