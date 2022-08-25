package com.example.usersapp.repoDAO;

import com.example.usersapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//TODO Read more about registering in spring
//@Repository not something you use in interfaces
public interface UserRepo extends JpaRepository<User, Long> {
  void deleteUserById(Long id );
//  @Query("SELECT u from User u where u.username=:username")
  Optional<User> findUserById(Long id);
  User findByUsername(String username);
}
