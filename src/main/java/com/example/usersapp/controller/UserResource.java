package com.example.usersapp.controller;


import com.example.usersapp.model.User;
import com.example.usersapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    //TODO look for annotation that restricts the access for each API
    public ResponseEntity<List<User>>  getAllUsers(){
        System.out.println("getAllUsers");
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User>  getUserById(@PathVariable("id") Long id){
        System.out.println("UserResource: getUserById");
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User>  addUser(@RequestBody User user){
        System.out.println("UserResource: addUser");
        User newUser =userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User>  updateUser(@RequestBody User user){
        System.out.println("UserResource: updateUser");
        User newUser =userService.updateUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>  deleteUserById(@PathVariable("id") Long id){
        System.out.println("UserResource: deleteUserById");
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
