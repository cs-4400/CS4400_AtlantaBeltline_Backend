package com.CS4400.AtlantaBeltLine.Controller;
import com.CS4400.AtlantaBeltLine.DTO.UserDTO;
import com.CS4400.AtlantaBeltLine.Util.Constants;
import com.CS4400.AtlantaBeltLine.DAO.UserDAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class AtlantaBeltLineController {
    private static final Logger LOGGER = LogManager.getLogger(AtlantaBeltLineController.class);

    @Autowired
    UserDAO userDAO;

    @RequestMapping(value = Constants.USER_ENDPOINT, method = RequestMethod.GET, produces = "application/json")
    public List<UserDTO> getUsers() {
        LOGGER.info("Getting Users");
        return userDAO.getAllUsers();
    }

    @RequestMapping(value = "/getString", produces = "application/json")
    public Map getString() {
        return Collections.singletonMap("response", "Hello World");
    }

}

