package com.lgi.theweschshop.shopdata.controller;

import com.lgi.theweschshop.shopdata.enums.Gender;
import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.model.Picture;
import com.lgi.theweschshop.shopdata.model.SizeEntity;
import com.lgi.theweschshop.shopdata.model.Type;
import com.lgi.theweschshop.shopdata.requests.CommentRequestDTO;
import com.lgi.theweschshop.shopdata.requests.ElementSaveRequestDTO;
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
@Controller
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
        registry.addViewController( "/admins" ).setViewName( "elementListEditor" );
        registry.addViewController( "/admin_element" ).setViewName( "addNewElement" );
        registry.addViewController( "/" ).setViewName( "index" );
        registry.addViewController( "/index" ).setViewName( "index" );
        registry.addViewController( "/hello" ).setViewName( "hello" );
        registry.addViewController( "/shop" ).setViewName( "shop" );
//        registry.addViewController( "/add" ).setViewName( "add" );
//        registry.addViewController( "/login" ).setViewName( "login" );

    }


    @GetMapping("admins")
    public String adminPage( Model model ) {

        getElementsToModel( model );
        return "admins";
    }

    private void getElementsToModel( Model model ) {
        List<ElementResponse> allElements = elementService.getAllElementsResponse();
        model.addAttribute( "rows", allElements.size() < 1 ? 1 : allElements.size() );
        model.addAttribute( "elements", allElements );
    }

    @GetMapping("admin_element")
    public String adminElementPage( Model model ) {

        List<Type> allTypes = typeService.getAllTypes();
        List<Gender> allGender = genderService.getAllGender();
        List<SizeEntity> allSize = sizeEntityService.getAllSize();

        getElementsToModel( model );
        model.addAttribute( "types", allTypes );
        model.addAttribute( "gender", allGender );
        model.addAttribute( "size", allSize );
        return "admin_element";
    }

    @GetMapping("saveElement")
    public String editElementList( ElementSaveRequestDTO requestDTO, Model model ) {
        elementService.save( requestDTO );
        getElementsToModel( model );
        return "redirect:/admins";
    }

    @PostMapping("delete/{id}")
    public String deleteElement( Model model, @PathVariable Long id ) {
        elementService.delete( id );
        getElementsToModel( model );
        return "redirect:/admins";
    }

    @GetMapping("saveSize")
    public String saveSize( Model model, @RequestParam String size ) {
        sizeEntityService.saveSize( size );
        return adminElementPage( model );
    }

    @GetMapping("saveType")
    public String saveType( Model model, @RequestParam String type ) {
        typeService.saveType( type );
        return adminElementPage( model );
    }

    @GetMapping("edit/{id}")
    public String editElement( Model model, @PathVariable Long id ) {
        Optional<Element> elementById =
                elementService.getElementById( id );

        Element element = elementById.orElseThrow( NoSuchElementException::new );
        List<Picture> pictures = element.getPictures();
        model.addAttribute( "element", element );
        model.addAttribute( "pictures", pictures );
        model.addAttribute( "picturesSize", pictures.size() );
        return "element_edit";
    }

    @GetMapping("shop/{id}")
    public String getElement( Model model, @PathVariable Long id ) {
        Optional<Element> elementById =
                elementService.getElementById( id );

        Element element = elementById.orElseThrow( NoSuchElementException::new );
        List<Picture> pictures = element.getPictures();
        model.addAttribute( "element", element );
        model.addAttribute( "pictures", pictures );
        model.addAttribute( "picturesSize", pictures.size() );
        return "element";
    }

    @GetMapping("about")
    public String aboutShop() {

        return "about";
    }

    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("shop")
    public String list( Model model ) {
        List<Element> allElements = elementService.getAllElements();
        if ( allElements == null ) {
            allElements = new ArrayList<>();
        }
        int size = allElements.size();
        if ( size < 1 ) {
            size = 1;
        }
        model.addAttribute( "rows", size );
        model.addAttribute( "elements", allElements );
        return "shop";
    }

    @GetMapping("saveComment")
    public String saveComment( Model model, CommentRequestDTO commentRequestDTO ) {
        commentService.saveComment( commentRequestDTO );
        return editElement( model, commentRequestDTO.getId() );
    }


    @RequestMapping(value = "saveImage", method = RequestMethod.POST)
    public String saveImage( @RequestParam("img") MultipartFile file, @RequestParam Long id ) {
        pictureService.saveImage( file, id );
        return "admins";
    }
}
