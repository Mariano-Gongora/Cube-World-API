package com.example.demo.API.Services;

import com.example.demo.API.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.API.Models.UserModel;
import java.util.*;

@Service
public class UserServices {
    @Autowired
    private UserRepo repository;

    public List<UserModel> getAllUsers(){
        return repository.getAllUsers();
    }

    public Optional<UserModel> getUser(long id){
        return repository.findById(id);
    }

    public UserModel addUser(UserModel profile){
        return repository.save(profile);
    }


    public UserModel updateUser(UserModel profile){
        return repository.save(profile);
    }

    public UserModel findByEmail(String Email){
        return repository.findByEmail(Email);
    }

    public void deleteUser(long id){
        repository.deleteById(id);
        System.out.println("user from id: "+id+" was deleted");
    }

    public UserModel findByEmailAndPassword(String Email, String Password) {
        return repository.findByEmailAndPassword(Email, Password);
    }

}
