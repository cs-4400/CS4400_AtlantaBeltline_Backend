package com.CS4400.AtlantaBeltLine.DAO;

import com.CS4400.AtlantaBeltLine.DTO.User_LoginDTO;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class  User_LoginDAOImp implements User_LoginDAO {
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(UserDAO.class);


    private static final String USER_LOGIN_VIEW = "user_login_test";
    private static final String SELECT_ALL_USER_LOGIN = "SELECT * FROM " + USER_LOGIN_VIEW;
//    private static final String GET_USER = "SELECT * FROM " + USER_LOGIN_VIEW + " WHERE email = ? AND password = ?";
    private static final String GET_USER = "call login_user(?)";




    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<User_LoginDTO> getAllUserLogins() {
        return jdbcTemplate.query(SELECT_ALL_USER_LOGIN, (rs, s) -> {
            User_LoginDTO user_loginDTO = new User_LoginDTO();
            user_loginDTO.setEmail(rs.getString("email"));
            user_loginDTO.setUname1(rs.getString("uname1"));
            user_loginDTO.setPassword(rs.getString("password"));
            user_loginDTO.setUser_type(rs.getString("user_type")); //? why isn't this column enum type?
            return user_loginDTO;
        });
    }

    @Override
    public User_LoginDTO checkUserLogin(String email) {
        return jdbcTemplate.query(GET_USER, new Object[]{email}, new ResultSetExtractor<User_LoginDTO>() {
            @Override
            public User_LoginDTO extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()) {
                    User_LoginDTO user_loginDTO = new User_LoginDTO();
                    user_loginDTO.setEmail(rs.getString("email"));
                    user_loginDTO.setPassword(rs.getString("password"));
                    user_loginDTO.setUname1(rs.getString("uname1"));
                    user_loginDTO.setUser_type(rs.getString("user_type"));
                    return user_loginDTO;
                }
                return null;
            }
        });
    }
}
