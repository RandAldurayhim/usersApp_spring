package com.example.usersapp.service;

import com.example.usersapp.exception.UserNotFoundException;
import com.example.usersapp.model.Privilege;
import com.example.usersapp.model.Role;
import com.example.usersapp.model.User;
import com.example.usersapp.repoDAO.RoleRepo;
import com.example.usersapp.repoDAO.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;

    private RoleRepo roleRepository;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user){
        return userRepo.save(user);
    }
    public List<User> findAllUsers(){
        return userRepo
                .findAll();
    }
    public User updateUser(User user){
        return userRepo.save(user);
    }
    public void deleteUser(Long id){
        userRepo.deleteUserById(id);
    }
    public User findUserById(Long id){
        return userRepo.findUserById(id).orElseThrow(() ->new UserNotFoundException( "User by id "+id +" was not found"));
    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println("UserService:loadUserByUsername");
//        User user = userRepo.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("Username not found "+username);
//        }
//        return new SecurityUser(user);
//    }
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepo.findByUsername(username);
        if (user == null) {
            return new org.springframework.security.core.userdetails.User(
                    " ", " ", true, true, true, true,
                    getAuthorities(Arrays.asList(
                            roleRepository.findByName("CLIENT"))));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), true, true, true,
                true, getAuthorities(user.getRoles()));
    }
    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Role> roles) {

        return getGrantedAuthorities(getPrivileges(roles));
    }
    private List<String> getPrivileges(Collection<Role> roles) {

        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();
        for (Role role : roles) {
            privileges.add(role.getName());
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

//    private UserDTO convertEntityToDTO(User user){
//        System.out.println("UserService:convertEntityToDTO");
//        UserDTO userDTO = new UserDTO();
//        userDTO.setUsername(user.getUsername());
//        return userDTO;
//    }
//    private Collection<? extends GrantedAuthority> getAuthorities(
//            Collection<Role> roles) {
//
//        return getGrantedAuthorities(getPrivileges(roles));
//    }
}
