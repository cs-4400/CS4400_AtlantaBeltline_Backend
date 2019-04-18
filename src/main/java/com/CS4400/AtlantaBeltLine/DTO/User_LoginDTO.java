package com.CS4400.AtlantaBeltLine.DTO;

public class User_LoginDTO {

    private String email;
    private String password;
    private String uname1;
//    private enum user_type;


    public User_LoginDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUname1() {
        return uname1;
    }

    public void setUname1(String uname1) {
        this.uname1 = uname1;
    }
}
