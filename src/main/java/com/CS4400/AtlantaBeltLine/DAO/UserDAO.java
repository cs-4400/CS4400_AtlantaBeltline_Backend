package com.CS4400.AtlantaBeltLine.DAO;

import com.CS4400.AtlantaBeltLine.DTO.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();
    public User getUser(String username);
    public int createUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
}
