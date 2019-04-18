package com.CS4400.AtlantaBeltLine.DAO;

import com.CS4400.AtlantaBeltLine.DTO.User_LoginDTO;

import java.util.List;

public interface User_LoginDAO {
    public List<User_LoginDTO> getAllUserLogins();
    public User_LoginDTO checkUserLogin(String email, String password);
}
