//package com.lgi.theweschshop.shopdata.controller;
//
//import com.lgi.theweschshop.shopdata.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import java.security.Principal;
//
///**
// * Created by Igor Yurchenko on 11/2/17.
// */
//@Controller
//public class LoginController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/login")
//    public String login( HttpServletRequest request, Principal principal ) {
//        if ( principal != null ) {
//            SecurityContextHolder.getContext().setAuthentication( null );
//            return "redirect:/login?logout";
//        }
//        String referrer = request.getHeader("Referer");
//        if (referrer == null || referrer.contains("signup") || referrer.contains("login")) {
//            referrer = "/";
//        }
//        request.getSession().setAttribute("url_prior_login", referrer);
//        return "login";
//    }
//}
