package com.lgi.theweschshop.shopdata.controller;

import com.lgi.theweschshop.shopdata.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
@Controller
public class ElementController {
    @Autowired
    private ElementService elementService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/admina")
    public String list() {
        return "admina";
    }


}
