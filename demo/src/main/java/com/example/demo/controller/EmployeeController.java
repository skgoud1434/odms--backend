package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/xto10x")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(){
        List<Employee> employees = service.getEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    
    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee obj){
        Employee employee = service.addEmployee(obj);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id){
        Employee employee = service.getEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    
    @GetMapping("/employees/by-manager/{mEmail}")
    public ResponseEntity<List<Employee>> getEmployeesByManagerEmail(@PathVariable String mEmail){
        List<Employee> employees = service.getEmployeesByManagerEmail(mEmail);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employees/by-employee/{eEmail}")
    public ResponseEntity<Employee> getManagerByEmployeeEmail(@PathVariable String eMail){
        Employee manager = service.getManagerByEmployeeEmail(eMail);
        return new ResponseEntity<>(manager, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployeeDetails(@PathVariable Integer id){
        service.deleteEmployeeDetails(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
