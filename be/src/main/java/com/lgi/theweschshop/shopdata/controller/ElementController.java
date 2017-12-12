package com.lgi.theweschshop.shopdata.controller;

import com.lgi.theweschshop.shopdata.entity.Element;
import com.lgi.theweschshop.shopdata.entity.Type;
import com.lgi.theweschshop.shopdata.requests.ElementRequest;
import com.lgi.theweschshop.shopdata.service.ElementService;
import com.lgi.theweschshop.shopdata.service.TypeService;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
@Controller
public class ElementController extends WebMvcConfigurerAdapter{

    private static final Logger l = LoggerFactory.getLogger( "" );

    @Autowired
    private ElementService elementService;

    @Autowired
    private TypeService typeService;


    @Override
    public void addViewControllers( ViewControllerRegistry registry ) {
        registry.addViewController( "/" ).setViewName( "index" );
        registry.addViewController( "/index" ).setViewName( "index" );
//        registry.addViewController( "/list" ).setViewName( "list" );
//        registry.addViewController( "/add" ).setViewName( "add" );
//        registry.addViewController( "/login" ).setViewName( "login" );

    }

    @GetMapping("index")
    public String index() {

        return "index";
    }

//    @GetMapping("list")
//    public String list( @RequestParam @NotEmpty String type, Pageable pageable, Model model ) {
//        Type typeByTypeName = typeService.findTypeByTypeName( type );
//        if ( typeByTypeName == null ) {
//            throw new IllegalArgumentException();
//        }
//        List<Element> allElements = elementService.getElementsListByType( typeByTypeName, pageable );
//        model.addAttribute( "rows", allElements.size() );
//        model.addAttribute( "elements", allElements );
//        return "index";
//    }
//
//    @PostMapping("add")
//    public String addElement( @RequestParam String elementName,
//                              @RequestParam String description ) {
//
//        elementService.addElement( elementName, description );
//
//        return "redirect:/";
//    }
//
//    @PostMapping("delete")
//    public String delete( Model model, @RequestParam Number elementId ) {
//        Optional<Element> elementById = elementService.getElementById( elementId );
//        Element element = elementById.orElseThrow( NoSuchElementException::new );
//        elementService.delete( element );
//        return "redirect:/element/list";
//    }
}
