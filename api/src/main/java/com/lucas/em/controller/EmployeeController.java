package com.lucas.em.controller;

import com.lucas.em.model.Employee;
import com.lucas.em.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    @Operation(summary = "Get all employees")
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get employee by id")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id){
        return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    @Operation(summary = "Create employee")
    public ResponseEntity<Employee> postEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.postEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    @Operation(summary = "Edit employee")
    public ResponseEntity<Employee> editEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.editEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete employee")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
