package com.lgi.theweschshop.shopdata.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.security.Principal;

/**
 * Created by Igor Yurchenko on 10/31/17.
 */
@Aspect
@Component
public class AspectSetter {

    @Before(value = "within(com.lgi.theweschshop.shopdata.controller..*) && args(model, principal,..)", argNames = "model, principal")
    public void setCurrentLoginIfPresent( Model model, Principal principal) {
        if (principal != null) {
            model.addAttribute("currentLogin", principal.getName());
        }
    }
}
