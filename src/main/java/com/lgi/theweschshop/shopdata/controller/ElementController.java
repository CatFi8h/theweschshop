package com.lgi.theweschshop.shopdata.controller;

import com.lgi.theweschshop.shopdata.entity.Element;
import com.lgi.theweschshop.shopdata.service.ElementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
@Controller
public class ElementController {

    private static final Logger l = LoggerFactory.getLogger( "" );

    @Autowired
    private ElementService elementService;

    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("/element/list")
    public String list( Model model ) {
        List<Element> allElements = elementService.getAllElements();
        model.addAttribute( "elements", allElements );
        return "admina";
    }

    @PostMapping("/addElement")
    public String addElement( @RequestParam String elementName,
                              @RequestParam String description ) {

        elementService.addElement( elementName, description );

        return "redirect:/";
    }

    @PostMapping("element/delete")
    public String delete( Model model, @RequestParam Integer elementId ) {
        Optional<Element> elementById = elementService.getElementById( elementId );
        Element element = elementById.orElseThrow( NoSuchElementException::new );
        elementService.delete( element );
        return "redirect:/element/list";
    }
}
