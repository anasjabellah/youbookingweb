package com.example.youbookingweb.services.implementation;

import com.example.youbookingweb.entities.Role;
import com.example.youbookingweb.repositories.RoleRepository;
import com.example.youbookingweb.services.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void updateRole(Role role , Long id) {
        Role role1 = roleRepository.findById(id).orElse(null);
        role1.setRoleName(role.getRoleName());
        roleRepository.save(role1);
    }

    @Override
    public Boolean DeleteRole(Long id) {
        roleRepository.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public List<Role> GetAllRoles() {
        return roleRepository.findAll();
    }
}
