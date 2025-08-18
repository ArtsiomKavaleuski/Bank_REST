package by.koval.bankcards.service;

import by.koval.bankcards.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();
    Role addRole(Role role);
    void deleteRole(Role role);
}
