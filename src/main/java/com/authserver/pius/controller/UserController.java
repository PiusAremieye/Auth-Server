package com.authserver.pius.controller;

import com.authserver.pius.model.User;
import com.authserver.pius.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(path = "/signup", method = RequestMethod.POST)
    public User addUsers(User user){
        return userService.create(user);
    }
}
