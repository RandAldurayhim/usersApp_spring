package com.example.usersapp.controller;


import com.example.usersapp.model.Role;
import com.example.usersapp.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleResource {
    private final RoleService roleService;

    public RoleResource(RoleService roleService) {
        this.roleService = roleService;
    }


    @PostMapping("/add")
    public ResponseEntity<Role>  addRole(@RequestBody Role role){
        System.out.println("addRole");
        Role newRole = roleService.addRole(role);
        return new ResponseEntity<>(newRole, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>  deleteById(@PathVariable("id") Long id){
        System.out.println("RoleResource: deleteById");
        roleService.deleteRole(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
