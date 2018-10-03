package com.jwt.controller;

import com.jwt.model.Employee;
import com.jwt.model.Role;
import com.jwt.service.EmployeeService;
import com.jwt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final RoleService roleService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, RoleService roleService) {
        this.employeeService = employeeService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String getEmployee(Model model) {
        List<Employee> employee = employeeService.getAll();
        List<Role> role = roleService.getAllRoles();
        model.addAttribute("employee", employee);
        model.addAttribute("role", role);
        model.addAttribute("employeeAttribute", new Employee());
        return "/employee/home";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id") Integer id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
        List<Role> role = roleService.getAllRoles();
        model.addAttribute("role", role);
        model.addAttribute("employeeAttribute", new Employee());
        return "/employee/addpage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Employee employee, String role) {
        String[] split = role.split(",");
        Set<Role> usr = new HashSet<>();
        for (String aSplit : split) {
            usr.add(roleService.getRoleByName(aSplit));
        }
        employee.setRole(usr);
        employeeService.addEmployee(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEdit(Employee employee,
                           String role) {
        String[] split = role.split(",");
        Set<Role> usr = new HashSet<>();
        for (String aSplit : split) {
            usr.add(roleService.getRoleByName(aSplit));
        }
        employee.setRole(usr);
        employeeService.updateEmployee(employee);
        return "redirect:/employee";
    }
}