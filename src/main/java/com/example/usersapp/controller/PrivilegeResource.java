package com.example.usersapp.controller;


import com.example.usersapp.model.Privilege;
import com.example.usersapp.model.Role;
import com.example.usersapp.model.User;
import com.example.usersapp.service.PrivilegeService;
import com.example.usersapp.service.RoleService;
import com.example.usersapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/privilege")
public class PrivilegeResource {
    private final PrivilegeService privilegeService;

    public PrivilegeResource(PrivilegeService privilegeService) {
        this.privilegeService = privilegeService;
    }
//    @GetMapping("/all")
//    public String index() {
//        return "login";
//    }

    @PostMapping("/add")
    public ResponseEntity<Privilege>  addPrivilege(@RequestBody Privilege privilege){
        System.out.println("PrivilegeResource: addPrivilege");
        Privilege newPrivilege = privilegeService.addPrivilege(privilege);
        return new ResponseEntity<>(newPrivilege, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>  deleteById(@PathVariable("id") Long id){
        System.out.println("PrivilegeResource: deleteById");
        privilegeService.deletePrivilege(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
