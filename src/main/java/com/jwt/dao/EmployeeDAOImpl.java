package com.jwt.dao;

import com.jwt.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Repository("employeeDao")
@Transactional
public class EmployeeDAOImpl extends AbstractDao<Integer,Employee> implements EmployeeDAO {
//    @Autowired
//    RoleDAO roleDAO;

    @Override
    public void addEmployee(Employee employee) {
        persist(employee);
    }

    @Override
    public List<Employee> getAll() {
        return  getEm().createQuery("select a from Employee a", Employee.class)
                .getResultList();
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        Employee employee = find(employeeId);
        delete(employee);
    }

    @Override
    public Employee getEmployee(Integer employeeId) {
        return find(employeeId);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        merge(employee);
        return employee;
    }

    @Override
    public Employee findEmployeeByLogin(String login) {
        Query query = getEm().createQuery("select employee from Employee as employee" +
                " where employee.login =:login", Employee.class);
        query.setParameter("login", login);
        return (Employee) query.getSingleResult();
    }
}