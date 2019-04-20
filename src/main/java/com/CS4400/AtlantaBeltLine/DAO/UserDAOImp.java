package com.CS4400.AtlantaBeltLine.DAO;

import com.CS4400.AtlantaBeltLine.DTO.UserDTO;
import com.CS4400.AtlantaBeltLine.Util.Status;
import com.CS4400.AtlantaBeltLine.Util.User_Type;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(UserDAO.class);

    private static final String USER_TABLE = "user";
    private static final String SELECT_ALL_USERS = "SELECT * FROM " + USER_TABLE;
    private static final String CREATE_USER = "INSERT INTO " + USER_TABLE + " (username, password, first_name, last_name, status, user_type) VALUES (?,?,?,?,?,?,?)";


    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<UserDTO> getAllUsers() {

        return jdbcTemplate.query(SELECT_ALL_USERS, (rs, i) -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(rs.getString("username"));
            userDTO.setPassword(rs.getString("password"));
            userDTO.setFirstName(rs.getString("first_name"));
            userDTO.setLastName(rs.getString("last_name"));
            userDTO.setStatus(Status.getStatusType(rs.getString("status")));
            userDTO.setUser_type(User_Type.getUserType(rs.getString("user_type")));
            return userDTO;
        });
    }

    @Override
    public UserDTO getUser(String username) {
        return null;
    }

    @Override
    public int createUser(UserDTO userDTO) {
//        String sql = "INSERT INTO user(Username, Password, FirstName, LastName, Status) values(?,?,?,?,?,?)";

        try {
            int counter = jdbcTemplate.update(CREATE_USER,
                    new Object[] {userDTO.getUsername(), userDTO.getPassword(), userDTO.getLastName(), userDTO.getPassword(), userDTO.getStatus(), userDTO.getUser_type()});
            return counter;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
//        return 0;
    }

    @Override
    public void updateUser(UserDTO userDTO) {

    }

    @Override
    public void deleteUser(UserDTO userDTO) {

    }
}
