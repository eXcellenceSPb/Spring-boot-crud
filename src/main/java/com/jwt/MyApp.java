package com.jwt;

import com.jwt.configuration.TestsUsers;
import com.jwt.service.EmployeeService;
import com.jwt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
    @Bean(initMethod = "init")
    @Autowired
    public TestsUsers tests(EmployeeService employeeService, RoleService roleService) {
        return new TestsUsers(employeeService, roleService);
    }
}
