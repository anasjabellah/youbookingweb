package com.example.youbookingweb.services;

import com.example.youbookingweb.entities.Hotel;
import com.example.youbookingweb.entities.Role;

import java.util.List;

public interface RoleService {

    // add role
    void  addRole(Role role);
    // update Role
    void updateRole(Role role , Long id);
    // delete Role
    Boolean DeleteRole(Long id);

    List<Role> GetAllRoles();
}
