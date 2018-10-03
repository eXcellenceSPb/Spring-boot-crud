package com.jwt.service;

import com.jwt.model.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);

    List<Employee> getAll();

    void deleteEmployee(Integer employeeId);

    Employee getEmployee(Integer employeeId);

    Employee updateEmployee(Employee employee);

    Employee findEmployeeByLogin(String login);
}