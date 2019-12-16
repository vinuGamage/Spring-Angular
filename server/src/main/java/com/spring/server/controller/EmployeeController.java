package com.spring.server.controller;

import com.spring.server.model.Employee;
import com.spring.server.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.EmployeeList();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable(value = "id") long id){
       return employeeService.getEmployee(id);
    }


}
