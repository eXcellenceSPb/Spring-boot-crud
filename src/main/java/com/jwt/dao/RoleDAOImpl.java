package com.jwt.dao;

import com.jwt.model.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class RoleDAOImpl extends AbstractDao<Integer, Role> implements RoleDAO {

    @Override
    public Role getRole(Integer id) {
        return find(id);
    }

    @Override
    public void addRole(Role role) {
        persist(role);
    }

    @Override
    public List<Role> getAll() {
        return getEm().createQuery("select role from Role as role", Role.class)
                .getResultList();
    }

    @Override
    public Role updateRole(Role role) {
        merge(role);
        return role;
    }

    @Override
    public void deleteRole(int roleId) {
        Role role = find(roleId);
        delete(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        Query query = getEm().createQuery("select role from Role as role" +
                " where role.role =:roleName", Role.class);
        query.setParameter("roleName", roleName);
        return (Role) query.getSingleResult();
    }
}
