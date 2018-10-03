package com.jwt.dao;

import com.jwt.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    void addEmployee(Employee employee);

    List<Employee> getAll();

    void deleteEmployee(Integer employeeId);

    Employee getEmployee(Integer employeeId);

    Employee updateEmployee(Employee employee);

    Employee findEmployeeByLogin(String login);

}
