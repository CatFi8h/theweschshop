package com.lgi.theweschshop.shopdata.controller;

import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.requests.CartAddDTO;
import com.lgi.theweschshop.shopdata.requests.CartGetListRequestDTO;
import com.lgi.theweschshop.shopdata.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("cart/add")
    public String addToCart( Model model,
                             CartAddDTO cart) {
        cartService.addIdToCart( cart.getId(), cart.getAmount(), cart.getSessionId() );
        Collection<Element> cartForSession = cartService.getCartForSession( 1, "name", cart.getSessionId() );

        model.addAttribute( "elements", cartForSession );
        return "cart";
    }

    @GetMapping("cart/{id}/remove")
    public String removeFromCart( Model model, @PathVariable Long id, @PathVariable String sessionId ) {
        cartService.removeElementFromCart( id, sessionId );
        Collection<Element> cartForSession = cartService.getCartForSession( 1, "name", sessionId );
        model.addAttribute( "elements", cartForSession );
        return "cart";
    }

    @GetMapping("cart/list")
    public String getCartList( Model model, CartGetListRequestDTO cart ) {
        Collection<Element> cartForSession = cartService.getCartForSession(
                cart.getPage(),
                cart.getSort(),
                cart.getSessionId() );
        model.addAttribute( "elements", cartForSession );
        return "cart";
    }

    @GetMapping("")
    public String buySelectedItems() {
        return null;
    }
}
