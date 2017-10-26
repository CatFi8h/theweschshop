package com.lgi.theweschshop.shopdata.controller;

import com.lgi.theweschshop.shopdata.entity.User;
import com.lgi.theweschshop.shopdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/getUser")
    public void getUserData( String userId ) {
        Optional<User> userById = userService.getUserById( userId );

    }

    @PostMapping("/addUser")
    public void addUser() {
        User user = new User();
        userService.addUser( user );
    }
}
