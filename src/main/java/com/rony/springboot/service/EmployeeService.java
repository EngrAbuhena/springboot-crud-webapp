package com.rony.springboot.service;

import java.util.List;

import com.rony.springboot.model.Employee;

public interface EmployeeService{
    
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
}