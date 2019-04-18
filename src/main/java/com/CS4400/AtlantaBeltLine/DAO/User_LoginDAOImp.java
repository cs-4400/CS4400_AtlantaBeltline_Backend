package com.CS4400.AtlantaBeltLine.DAO;

import com.CS4400.AtlantaBeltLine.DTO.User_LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class User_LoginDAOImp implements User_LoginDAO {
    private static final String USER_LOGIN_VIEW = "user_login";
    private static final String SELECT_ALL_USER_LOGIN = "SELECT * FROM " + USER_LOGIN_VIEW;


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<User_LoginDTO> getAllUserLogins() {
        return jdbcTemplate.query(SELECT_ALL_USER_LOGIN, (rs, s) -> {
            User_LoginDTO user_loginDTO = new User_LoginDTO();
            user_loginDTO.setEmail(rs.getString("email"));
            user_loginDTO.setUname1(rs.getString("uname1"));
            user_loginDTO.setPassword(rs.getString("password"));
            return user_loginDTO;
        });
    }

    @Override
    public User_LoginDTO checkUserLogin(String email) {
        return null;
    }
}
