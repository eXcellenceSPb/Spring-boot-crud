package com.jwt.service;

import com.jwt.model.Role;

import java.util.List;

public interface RoleService {
    Role getRole(Integer id);
    void addRole(Role role);
    List<Role> getAllRoles();
    Role updateRole(Role role);
    void deleteRole(int roleId);
    Role getRoleByName(String roleName);
}
