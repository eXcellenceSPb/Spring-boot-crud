package com.jwt.controller.rest;

import com.jwt.model.Employee;
import com.jwt.service.EmployeeService;
import com.jwt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class MyRestController {
    private final PasswordEncoder passwordEncoder;

    private final RoleService roleService;

    private final
    EmployeeService employeeService;

    @Autowired
    public MyRestController(RoleService roleService, EmployeeService employeeService, PasswordEncoder passwordEncoder) {
        this.roleService = roleService;
        this.employeeService = employeeService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Employee> listAllUsers() {
        return employeeService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee getUser(@PathVariable("id") Integer id) {
        return employeeService.getEmployee(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void createUser(@RequestBody Employee employee) {
        Employee add = new Employee();
        add.setName(employee.getName());
        add.setLogin(employee.getLogin());
        add.setPass(employee.getPass());
        add.setEnabled(employee.isEnabled());
        add.setRole(employee.getRole());
        employeeService.addEmployee(add);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Employee updateUser(@PathVariable("id") Integer id,
                               @RequestBody Employee employee) {
        Employee currentEmployee = employeeService.getEmployee(id);
        currentEmployee.setName(employee.getName());
        currentEmployee.setLogin(employee.getLogin());
        currentEmployee.setPass(passwordEncoder.encode(employee.getPass()));
        currentEmployee.setRole(employee.getRole());
        currentEmployee.setEnabled(employee.isEnabled());
        employeeService.updateEmployee(currentEmployee);
        return currentEmployee;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
    }

}
