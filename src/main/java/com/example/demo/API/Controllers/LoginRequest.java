package com.example.demo.API.Controllers;

public class LoginRequest {
    private String Email;
    private String Password;

    public LoginRequest() {

    };

    public LoginRequest(String Password, String Email) {
        this.Email = Email;
        this.Password = Password;
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
}
