package com.CS4400.AtlantaBeltLine.DTO;

import com.CS4400.AtlantaBeltLine.Util.User_Type;

public class User_LoginDTO {

    private String email;
    private String password;
    private String uname1;
    private String user_type;


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

    public String getUser_type(User_Type user_type) {
        return user_type.type;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
}
