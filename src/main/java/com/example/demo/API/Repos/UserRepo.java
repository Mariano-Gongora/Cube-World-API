package com.example.demo.API.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.API.Models.UserModel;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Long> {
    
    @Query("SELECT u FROM UserModel u")
    List<UserModel> getAllUsers();

    @Query("SELECT u FROM UserModel u WHERE u.Email LIKE %:Email%")
    UserModel findByEmail(@Param("Email") String Email);

    @Query("SELECT u FROM UserModel u WHERE u.Email = :Email AND u.Password = :Password")
    UserModel findByEmailAndPassword(@Param("Email") String Email, @Param("Password") String Password);


}


