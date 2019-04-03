package com.CS4400.AtlantaBeltLine.DTO;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Username")
    private String Username;
    @Column(name = "Password")
    private String Password;
    @Column(name = "FirstName")
    private String FirstName;
    @Column(name = "LastName")
    private String LastName;
    @Column(name = "Status")
    private int Status;

    public UserDTO() {
    }

    public UserDTO(String username, String password, String firstName, int status) {
        this.Username = username;
        this.Password = password;
        this.FirstName = username;
        this.Status = status;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String toString(){
        return Username + "|" + FirstName + "|" + LastName + "| Status: " + Status;
    }


}
