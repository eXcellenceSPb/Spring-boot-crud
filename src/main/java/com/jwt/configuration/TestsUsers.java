package com.jwt.configuration;

import com.jwt.model.Employee;
import com.jwt.model.Role;
import com.jwt.service.EmployeeService;
import com.jwt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class TestsUsers {

    private RoleService roleService;

    private EmployeeService employeeService;

    @Autowired
    public TestsUsers(EmployeeService employeeService, RoleService roleService) {
        this.employeeService = employeeService;
        this.roleService = roleService;
    }

    public void init() {
        Role adm = new Role("ROLE_ADMIN");
        Role usr = new Role("ROLE_USER");
        roleService.addRole(adm);
        roleService.addRole(usr);
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getRoleByName("ROLE_ADMIN"));
        roles.add(roleService.getRoleByName("ROLE_USER"));
        Employee employee = new Employee();
        employee.setRole(roles);
        employee.setName("qwe");
        employee.setPass("qwe");
        employee.setLogin("qwe");
        employee.setEnabled(true);
        employeeService.addEmployee(employee);
    }
}
