//package com.lgi.theweschshop.shopdata.controller;
//
//import com.lgi.theweschshop.shopdata.entity.User;
//import com.lgi.theweschshop.shopdata.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.Date;
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
///**
// * Created by Igor Yurchenko on 10/26/17.
// */
//@Controller
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//
//    @GetMapping("/user/get")
//    public String getUserData( Model model, @RequestParam String userId ) {
//        Optional<User> userById = userService.getUserById( userId );
//        User user = userById.orElseThrow( NoSuchElementException::new );
//        model.addAttribute( "user", user.toString() );
//        return "user";
//    }
//
//    @PostMapping("/user/add")
//    public String addUser( @RequestParam String email,
//                           @RequestParam String userName,
//                           @RequestParam String password ) {
//        User user = new User( email, userName, password );
//        userService.addUser( user );
//        return "redirect:/user/list";
//    }
//
//    @GetMapping("/user/list")
//    public String getUserList( Model model ) {
//        List<User> userList = userService.getUserList();
//        model.addAttribute( "userList", userList );
//        model.addAttribute( "time", new Date( System.currentTimeMillis() ).toString() );
//        return "users";
//    }
//
//    @PostMapping("/user/delete")
//    public String deleteUser( @RequestParam String email ) {
//        Optional<User> userById = userService.getUserById( email );
//        User user = userById.orElseThrow( NoSuchElementException::new );
//        userService.delete( user );
//        return "redirect:/user/list";
//    }
//}
