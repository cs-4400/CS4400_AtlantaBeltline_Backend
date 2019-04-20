package com.CS4400.AtlantaBeltLine.DTO;

import com.CS4400.AtlantaBeltLine.Util.Status;
import com.CS4400.AtlantaBeltLine.Util.User_Type;

import javax.persistence.*;

//@Entity
//@Table(name = "user")
public class UserDTO {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "Username")
    private String username;
//    @Column(name = "Password")
    private String password;
//    @Column(name = "FirstName")
    private String firstName;
//    @Column(name = "LastName")
    private String lastName;

    private Status status;
//
    private User_Type user_type;

    public UserDTO() {
    }

    public UserDTO(String username, String password, String firstName, String lastName, Status status, User_Type user_type) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.user_type = user_type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User_Type getUser_type() {
        return user_type;
    }

    public void setUser_type(User_Type user_type) {
        this.user_type = user_type;
    }

    public String toString(){
        return username + "|" + firstName + "|" + lastName;
    }



}
