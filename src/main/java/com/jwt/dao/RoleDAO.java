package com.jwt.dao;

import com.jwt.model.Role;

import java.util.List;

public interface RoleDAO {
    Role getRole(Integer id);
    void addRole(Role role);
    List<Role> getAll();
    Role updateRole(Role role);
    void deleteRole(int roleId);
    Role getRoleByName(String roleName);
}
