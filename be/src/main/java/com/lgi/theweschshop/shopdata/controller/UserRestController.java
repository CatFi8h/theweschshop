package com.lgi.theweschshop.shopdata.controller;

import com.lgi.theweschshop.shopdata.model.EUser;
import com.lgi.theweschshop.shopdata.requests.AddUserRequest;
import com.lgi.theweschshop.shopdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Igor Yurchenko on 10/30/17.
 */
@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/list")
    public List<EUser> getList() {
        List<EUser> userList = userService.getUserList();
        return userList;
    }

    @PostMapping("user/add")
    public void addUser(@Valid AddUserRequest request) {

        userService.addUser(request.getEmail(), request.getName(), request.getSurname(), request.getPassword());

    }

    @PostMapping("user/delete")
    public void deleteUser(@RequestParam String email) {

//        userService.delete(email);

    }


}
