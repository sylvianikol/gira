package com.exam.gira.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {

    private String email;
    private String password;

    public UserLoginBindingModel() {
    }

    @NotBlank(message = "Email can not be null or empty")
    @Email(message = "Email not valid!")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotBlank(message = "Password can not be null or empty")
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters ")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
