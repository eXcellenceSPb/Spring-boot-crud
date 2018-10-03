package com.jwt.service;

import com.jwt.dao.EmployeeDAO;
import com.jwt.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void addEmployee(Employee employee) {
        employee.setPass(passwordEncoder.encode(employee.getPassword()));
        employeeDAO.addEmployee(employee);
    }

    public Employee getEmployee(Integer employeeId) {
        return employeeDAO.getEmployee(employeeId);
    }

    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }

    public void deleteEmployee(Integer employeeId) {
        employeeDAO.deleteEmployee(employeeId);
    }

    public Employee findEmployeeByLogin(String login) {
        return employeeDAO.findEmployeeByLogin(login);
    }
}
