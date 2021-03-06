//package com.lgi.theweschshop.shopdata.controller.rest;
//
//import com.lgi.theweschshop.shopdata.model.EUser;
//import com.lgi.theweschshop.shopdata.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
///**
// * Created by Igor Yurchenko on 10/30/17.
// */
//@RestController
//public class UserRestController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/user/list")
//    public List<EUser> getList() {
//        List<EUser> userList = userService.getUserList();
//        return userList;
//    }
//
//    @PostMapping("user/add")
//    public EUser addUser( @RequestParam String email,
//                         @RequestParam String name,
//                         @RequestParam String surname,
//                         @RequestParam String pass ) {
//        EUser user = new EUser( email, name, surname, pass );
//        userService.addUser( user );
//        return user;
//    }
//
//    @PostMapping("user/delete")
//    public EUser deleteUser( @RequestParam String email ) {
//        Optional<EUser> userById = userService.getUserById( email );
//        EUser user = userById.orElseThrow( NoSuchElementException::new );
//        userService.delete( user );
//        return user;
//    }
//
//
//}
