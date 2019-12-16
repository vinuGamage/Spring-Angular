package com.spring.server.service;

import com.spring.server.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> EmployeeList();

    public Employee getEmployee(long id);

    public String saveEmployee(Employee employee);

    public String updateEmployee(Employee employee);

    public String deleteEmployee(long empId);

}
