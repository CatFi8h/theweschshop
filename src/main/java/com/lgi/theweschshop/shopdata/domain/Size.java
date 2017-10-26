package com.lgi.theweschshop.shopdata.domain;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
public enum Size {
    XS, S, M, L, XL, XXL;

    public Size valueOfIgnoreCase( String value ) {
        if ( value == null ) {
            throw new IllegalArgumentException();
        }
        for ( Size size : Size.values() ) {
            if ( value.equalsIgnoreCase( size.name() ) ) {
                return size;
            }
        }
        return Size.valueOf( value );
    }

}
