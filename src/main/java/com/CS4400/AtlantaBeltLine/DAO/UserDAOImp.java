package com.CS4400.AtlantaBeltLine.DAO;

import com.CS4400.AtlantaBeltLine.DTO.User;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDAOImp implements UserDAO {
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(UserDAO.class);

    private static final String USER_TABLE = "User";
    private static final String SELECT_ALL_USERS = "SELECT * FROM " + USER_TABLE;


    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public int createUser(User user) {
        String sql = "INSERT INTO user(Username, Password, FirstName, LastName, Status) values(?,?,?,?,?)";

        try {
            int counter = jdbcTemplate.update(sql,
                    new Object[] {user.getUsername(), user.getLastName(), user.getPassword(), user.getStatus()});
            return counter;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
}
