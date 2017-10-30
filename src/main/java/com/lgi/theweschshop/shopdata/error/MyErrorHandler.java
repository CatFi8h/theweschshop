package com.lgi.theweschshop.shopdata.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Igor Yurchenko on 10/29/17.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyErrorHandler extends RuntimeException {

    public MyErrorHandler() {
    }

    public MyErrorHandler( String message ) {
        super( message );
    }

    public String getMessage() {
        return "No page with such parameters";
    }
}
