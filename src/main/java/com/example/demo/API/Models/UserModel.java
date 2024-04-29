package com.example.demo.API.Models;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;


@Entity
@EntityScan
@Table(name = "User")
public class UserModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Email")
    @JsonProperty("Email")
    private String Email;

    @Column(name = "Password")
    @JsonProperty("Password")
    private String Password;

    @Column(name = "FirstName")
    @JsonProperty("FirstName")
    private String FirstName;

    @Column(name = "LastName")
    @JsonProperty("LastName")
    private String LastName;

    @Column(name = "CartList", length = Integer.MAX_VALUE)
    @JsonProperty("CartList")
    private List<Long> CartList;

    public UserModel() {

    }

    public UserModel(String FirstName, String LastName, String Email, String Password, List<Long> CartList) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.Password = Password;
        this.CartList=CartList;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getEmail() {
        return Email;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPassword() {
        return Password;
    }

    public List<Long> getCartList() {
        return this.CartList;
    }

    public void setCartList(List<Long> CartList) {
        this.CartList = CartList;
    }

}
