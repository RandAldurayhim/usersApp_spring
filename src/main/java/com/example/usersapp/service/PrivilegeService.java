package com.example.usersapp.service;

import com.example.usersapp.model.Privilege;
import com.example.usersapp.model.Role;
import com.example.usersapp.repoDAO.PrivilegeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeService {
    private final PrivilegeRepo privilegeRepo;
    @Autowired
    public PrivilegeService(PrivilegeRepo privilegeRepo) {
        this.privilegeRepo = privilegeRepo;
    }

    public Privilege addPrivilege(Privilege privilege){
        return privilegeRepo.save(privilege);
    }

    public void deletePrivilege(Long id){
        privilegeRepo.deleteById(id);
    }
}
