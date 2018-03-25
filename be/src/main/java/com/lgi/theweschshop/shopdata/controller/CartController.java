package com.lgi.theweschshop.shopdata.controller;

import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Collection;

@Controller
public class CartController extends WebMvcConfigurerAdapter {

    @Autowired
    private CartService cartService;

    @Override
    public void addViewControllers( ViewControllerRegistry registry ) {
        registry.addViewController( "/cart" ).setViewName( "cart" );
    }

    @GetMapping("cart/{id}/add")
    public String addToCart( Model model,
                             @PathVariable Long id,
                             @PathVariable Long amount,
                             @PathVariable String sessionId ) {
        cartService.addIdToCart( id, amount, sessionId );
        Collection<Element> cartForSession = cartService.getCartForSession( 1, "", sessionId );

        model.addAttribute( "cart", cartForSession );
        return "cart";
    }

    @GetMapping("cart/{id}/remove")
    public String removeFromCart( Model model, @PathVariable Long id, @PathVariable String sessionId ) {
        cartService.removeElementFromCart( id, sessionId );
        Collection<Element> cartForSession = cartService.getCartForSession( 1, "", sessionId );
        model.addAttribute( "cart", cartForSession );
        return "cart";
    }

    @GetMapping("cart/list")
    public String getCartList( Model model, @RequestParam(value = "sort", required = false) String sortType,
                               @RequestParam(value = "sessionId") String sessionId,
                               @RequestParam(value = "page", required = false, defaultValue = "1") int pageNumber ) {
        Collection<Element> cartForSession = cartService.getCartForSession( pageNumber, sortType, sessionId );
        model.addAttribute( "cart", cartForSession );
        return "cart";
    }

    @GetMapping("")
    public String buySelectedItems() {
        return null;
    }
}
