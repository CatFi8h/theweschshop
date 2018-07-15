package com.lgi.theweschshop.shopdata.service;

import com.lgi.theweschshop.shopdata.model.Element;

import java.util.List;

public interface CartService {

    List<Element> getCartForSession( int pageNumber, String sortType, String sessionId );

    void addIdToCart( Long id, Long amount, String sessionId );

    boolean removeElementFromCart( Long id, String sessionId );
}
