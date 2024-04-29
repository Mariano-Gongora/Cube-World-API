package com.example.demo.API.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.API.Models.UserModel;
import com.example.demo.API.Services.UserServices;


@RestController
@RequestMapping
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserServices service;

    @GetMapping("/getAllUsers")
    public List<UserModel> getAllUsers() {
        return service.getAllUsers();
    }

    @PostMapping("/login")
    public ResponseEntity<UserModel> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        UserModel user = service.findByEmailAndPassword(email, password);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @GetMapping("/getUser/{id}")
    public Optional<UserModel> getUser(@PathVariable long id) {
        return service.getUser(id);
    }

    @PostMapping("/setProfile")
    public void addUser(@RequestBody UserModel profile){
        service.addUser(profile);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable long id) {  
     service.deleteUser(id);
}

    @PutMapping("/updateUser/{id}")
    public void updateUser(@PathVariable long id,@RequestBody UserModel profile){
        profile.setId(id);
        service.updateUser(profile);
    }
}