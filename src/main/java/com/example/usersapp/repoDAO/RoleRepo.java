package com.example.usersapp.repoDAO;

import com.example.usersapp.model.Role;
import com.example.usersapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);

}

