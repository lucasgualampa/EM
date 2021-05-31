package com.lucas.em.service;

import com.lucas.em.model.Employee;
import com.lucas.em.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    // search all employee
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }
    // search employee by id
    public Employee getEmployee(Integer id){
        return employeeRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    // add new employee
    public Employee postEmployee(Employee employee){
        // UUID (Universally Unique Identifier)
        // A UUID is made up of hex digits  (4 chars each) along with 4 “-” symbols, which make its length equal to 36 characters.
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    // edit employee
    public Employee editEmployee(Employee employee){
        // If does not exist, it will throw an error
        employeeRepository.findById(employee.getId())
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        return employeeRepository.save(employee);
    }

    // delete employee by id
    public void deleteEmployee(Integer id){
        /*
        // if does not exist, it will throw an error
        employeeRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
         */
        try {
            employeeRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
