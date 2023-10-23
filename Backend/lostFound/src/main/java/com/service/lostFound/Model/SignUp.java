package com.service.lostFound.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "signup_user")
public class SignUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String mobileNumber;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean isAdmin;
    private Boolean isActive;
    public SignUp() {

    }
    public SignUp(String mobileNumber, String email, String password, String firstName, String lastName, Boolean isAdmin, Boolean isActive) {
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAdmin = isAdmin;
        this.isActive = isActive;
    }


}
