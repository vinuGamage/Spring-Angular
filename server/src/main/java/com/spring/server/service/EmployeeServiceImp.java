package com.spring.server.service;

import com.spring.server.entity.EmployeeEntity;
import com.spring.server.model.Employee;
import com.spring.server.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> EmployeeList() {
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
        List<Employee> employeeList = new ArrayList<>();
        for (EmployeeEntity employeeEntity:employeeEntityList) {
            Employee employee = new Employee();
            employee.setEmpId(employeeEntity.getEmpId());
            employee.setName(employeeEntity.getName());
            employee.setEmail(employeeEntity.getEmail());
            employeeList.add(employee);
        }
        return employeeList;
    }

    @Override
    public Employee getEmployee(long id) {
        EmployeeEntity employeeEntity = employeeRepository.getOne(id);
        Employee employee = null;
        if (employeeEntity != null){
            employee = new Employee();
            employee.setEmpId(employeeEntity.getEmpId());
            employee.setName(employeeEntity.getName());
            employee.setEmail(employeeEntity.getEmail());
        }
        return employee;
    }

    @Override
    public String saveEmployee(Employee employee) {
        EmployeeEntity employee1 = employeeRepository.getOne(employee.getEmpId());
        String message = "";
        if (employee1 == null){
            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.setEmpId(employee.getEmpId());
            employeeEntity.setName(employee.getName());
            employeeEntity.setEmail(employee.getEmail());
            employeeRepository.save(employeeEntity);
            message = "Employee was successfully registered";
        }else{
            message = "Employee email address already exists";
        }

        return message;
    }

    @Override
    public String updateEmployee(Employee employee) {
        EmployeeEntity employee1 = employeeRepository.getOne(employee.getEmpId());
        String message = "";
        if (employee1 != null){
            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.setEmpId(employee.getEmpId());
            employeeEntity.setName(employee.getName());
            employeeEntity.setEmail(employee.getEmail());
            employeeRepository.save(employeeEntity);
            message = "Employee was successfully updated";
        }else{
            message = "Employee does not exists";
        }

        return message;
    }

    @Override
    public String deleteEmployee(long empId) {
        String message="";
        EmployeeEntity employee = employeeRepository.getOne(empId);
        if (employee != null){
            employeeRepository.deleteById(empId);
            message = "Employee was successfully deleted";
        }else{
            message = "Error deleting the employee";
        }
        return message;
    }
}
