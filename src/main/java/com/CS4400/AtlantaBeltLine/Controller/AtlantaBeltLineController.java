package com.CS4400.AtlantaBeltLine.Controller;

import com.CS4400.AtlantaBeltLine.DAO.TransitDAO;
import com.CS4400.AtlantaBeltLine.DAO.UserDAO;

import com.CS4400.AtlantaBeltLine.DAO.User_LoginDAO;
import com.CS4400.AtlantaBeltLine.DTO.TransitDTO;
import com.CS4400.AtlantaBeltLine.DTO.UserDTO;
import com.CS4400.AtlantaBeltLine.DTO.User_LoginDTO;
import com.CS4400.AtlantaBeltLine.Util.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AtlantaBeltLineController {
    private static final Logger LOGGER = LogManager.getLogger(AtlantaBeltLineController.class);

    @Autowired
    UserDAO userDAO;

    @Autowired
    TransitDAO transitDAO;

    @Autowired
    User_LoginDAO user_loginDAO;


    @PostMapping(path = "/")
    public String welcome() {
        LOGGER.info("TESTING");
        return "アトランタベルトラインアプリへようこそ！";
    }


    @GetMapping(path = Constants.TRANSIT_ENDPOINT, produces = "application/json")
    public List<TransitDTO> getAllTransits() {
        LOGGER.info("Getting All Transit details.");
        return transitDAO.getAllTransits();
    }

    @GetMapping(path = Constants.USER_ENDPOINT, produces = "application/json")
    public List<UserDTO> getAllUsers() {
        LOGGER.info("Getting all users...");
        return userDAO.getAllUsers();
    }

    @GetMapping(path = Constants.USER_LOGIN_ENDPOINT, produces = "application/json")
    public List<User_LoginDTO> getAllUserLogins() {
        LOGGER.info("CHECKING user login");
        return user_loginDAO.getAllUserLogins();
    }

    @GetMapping(path = Constants.CHECK_USER_CREDENTIALS, produces = "application/json")
    public ResponseEntity checkCredentials(@RequestParam(value = "email", required = true) String email) {
        User_LoginDTO user_loginDTO = user_loginDAO.checkUserLogin(email);
        if (user_loginDTO == null) {
            return new ResponseEntity("No user found!!!!!!!" + email, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(user_loginDTO, HttpStatus.OK);
    }








//    @RequestMapping(value = "/transits")
//    public ModelAndView listTransits(@ModelAttribute("transit") TransitDTO transit) {
//        ModelAndView model = new ModelAndView("transit");
//
//        List transitList = transitDAO.getAllTransits();
//        System.out.println(transitList);
//        model.addObject("transitList", transitList);
//
//        return  model;
//    }
//
//
//    @RequestMapping(value = "/json", method = RequestMethod.GET, produces = "application/json")
//    @ResponseBody
//    public Map<String, Object> bar() {
//        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("test", "jsonRestExample");
//        return map;
//    }
//
//    @RequestMapping(value = Constants.USER_ENDPOINT, method = RequestMethod.GET, produces = "application/json")
//    public List<UserDTO> getUsers() {
//        LOGGER.info("Getting Users");
//        return userDAO.getAllUsers();
//    }
//
//    @GetMapping("/status/check")
//    public String status() {
//        return "working";
//    }
//
//    @RequestMapping("/home")
//    @ResponseBody
//    public String hello() {
//        return "Welcome to atlanta_beltline";
//    }
//
//    @GetMapping("/test")
//    public Map<String, String> sayHello() {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("key", "value");
//        map.put("foo", "bar");
//        map.put("aa", "bb");
//        return map;
//    }
//
//    @RequestMapping(value = "/getString", produces = "application/json")
//    public Map getString() {
//        return Collections.singletonMap("response", "Hello World");
//    }

}

