package com.CS4400.AtlantaBeltLine.DTO;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Username")
    private String username;
    @Column(name = "Password")
    private String password;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "Status")
    private int status;

    public UserDTO() {
    }

    public UserDTO(String username, String password, String firstName, int status) {
        this.username = username;
        this.password = password;
        this.firstName = username;
        this.status = status;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String toString(){
        return username + "|" + firstName + "|" + lastName + "| status: " + status;
    }

}
