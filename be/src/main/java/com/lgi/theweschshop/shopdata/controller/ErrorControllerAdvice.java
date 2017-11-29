package com.lgi.theweschshop.shopdata.controller;

import com.lgi.theweschshop.shopdata.error.MyErrorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Igor Yurchenko on 10/27/17.
 */
@ControllerAdvice
public class ErrorControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger( ErrorControllerAdvice.class );

    @SuppressWarnings("unused")
    @ExceptionHandler(MyErrorHandler.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404( Model model, HttpServletRequest request ) {
        LOGGER.warn( "{} - {}", request.getMethod(), request.getRequestURI() );
        return "404";
    }

}
