package com.example.usersapp.service;

import com.example.usersapp.model.Role;
import com.example.usersapp.repoDAO.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepo roleRepo;
    @Autowired
    public RoleService(RoleRepo roleRepo){
        this.roleRepo = roleRepo;
    }

    public Role addRole(Role role){
        return roleRepo.save(role);
    }

    public void deleteRole(Long id){
        roleRepo.deleteById(id);
    }
}
