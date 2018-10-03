package com.jwt.security;

import com.jwt.dao.EmployeeDAO;
import com.jwt.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CustomEmployeeDetailService implements UserDetailsService {
    @Autowired
    private EmployeeDAO employeeDAO;

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Employee domainEmployee = employeeDAO.findEmployeeByLogin(login);
        if (domainEmployee == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return domainEmployee;
    }
}
