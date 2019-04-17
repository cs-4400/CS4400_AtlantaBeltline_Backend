package com.CS4400.AtlantaBeltLine.DAO;

import com.CS4400.AtlantaBeltLine.DTO.UserDTO;

import java.util.List;

public interface UserDAO {
    public List<UserDTO> getAllUsers();
    public UserDTO getUser(String username);
    public int createUser(UserDTO userDTO);
    public void updateUser(UserDTO userDTO);
    public void deleteUser(UserDTO userDTO);
}
