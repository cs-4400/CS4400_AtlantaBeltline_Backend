package com.CS4400.AtlantaBeltLine.Controller;
import com.CS4400.AtlantaBeltLine.DTO.UserDTO;
import com.CS4400.AtlantaBeltLine.Util.Constants;
import com.CS4400.AtlantaBeltLine.DAO.UserDAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AtlantaBeltLineController {
    private static final Logger LOGGER = LogManager.getLogger(AtlantaBeltLineController.class);

    @Autowired
    UserDAO userDAO;

    @RequestMapping(value = Constants.USER_ENDPOINT, produces = "application/json")
    public List<UserDTO> getUsers() {
        LOGGER.info("Getting Users");
        return userDAO.getAllUsers();
    }


}

