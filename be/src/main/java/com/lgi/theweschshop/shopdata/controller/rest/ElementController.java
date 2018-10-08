package com.lgi.theweschshop.shopdata.controller.rest;

import com.lgi.theweschshop.shopdata.response.ElementListDto;
import com.lgi.theweschshop.shopdata.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
@RequestMapping("api/element")
@RestController
public class ElementController extends WebMvcConfigurerAdapter {

    private static final Logger l = LoggerFactory.getLogger( "" );

    @Autowired
    public ElementService elementService;

    @Autowired
    public TypeService typeService;

    @Autowired
    public GenderService genderService;

    @Autowired
    public SizeEntityService sizeEntityService;

    @Autowired
    public PictureService pictureService;

    @Autowired
    public CommentService commentService;

    @Override
    public void addViewControllers( ViewControllerRegistry registry ) {

    }

    @GetMapping(path = "list")
    public ElementListDto getListOfElements() {
        elementService.getAllElements();
        return null;
    }

    @PutMapping(path = "save")
    public void saveNewElement() {

    }

}
