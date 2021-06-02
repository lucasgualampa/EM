package com.lucas.em.controller;

import com.lucas.em.model.Employee;
import com.lucas.em.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/employees", produces = "application/json", method = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    @Operation(summary = "Get all employees")
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    @Operation(summary = "Get employee by id")
    public ResponseEntity<Employee> getEmployee(@PathParam("id") Integer id){
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

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete employee")
    public ResponseEntity<?> deleteEmployee(@PathParam("id") Integer id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
