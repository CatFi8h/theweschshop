package com.lgi.theweschshop.shopdata.controller;

import com.lgi.theweschshop.shopdata.enums.Gender;
import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.model.Picture;
import com.lgi.theweschshop.shopdata.model.SizeEntity;
import com.lgi.theweschshop.shopdata.model.Type;
import com.lgi.theweschshop.shopdata.requests.CommentRequestDTO;
import com.lgi.theweschshop.shopdata.requests.ElementSaveRequestDTO;
import com.lgi.theweschshop.shopdata.response.ElementListDto;
import com.lgi.theweschshop.shopdata.response.dto.ElementResponse;
import com.lgi.theweschshop.shopdata.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
@RequestMapping("api/element")
@Controller
public class ElementController extends WebMvcConfigurerAdapter {

    private static final Logger l = LoggerFactory.getLogger("");

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
    public void addViewControllers(ViewControllerRegistry registry) {

    }

    @GetMapping(path = "list")
    public ElementListDto getListOfElements() {
        return null;
    }

    @PutMapping(path = "save")
    public void saveNewElement() {

    }

}
