package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.repository.ElementRepository;
import com.lgi.theweschshop.shopdata.response.dto.CartElementDTO;
import com.lgi.theweschshop.shopdata.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    private Map<String, Set<CartElementDTO>> cart = new HashMap<>();

    @Autowired
    private ElementRepository elementRepository;

    @Override
    public List<Element> getCartForSession( int pageNumber, String sortType, String sessionId ) {
        Sort orders;

        if ( sortType == null ) {
            orders = new Sort( Sort.Direction.ASC );
        } else {
            orders = new Sort( Sort.Direction.ASC, sortType );
        }
        PageRequest pageRequest = new PageRequest( pageNumber - 1, 10, orders );
        Set<CartElementDTO> cartElementDTOS = cart.get( sessionId );
        if ( cartElementDTOS == null ) {
            cartElementDTOS = new HashSet<>();
        }
        Set<Long> longs = cartElementDTOS.stream().map( CartElementDTO::getElementId ).collect( Collectors.toSet() );
        if ( longs == null || longs.isEmpty() ) {
            return new ArrayList<>();
        }
        Page<Element> elementsById = elementRepository.findElementsById( pageRequest, new ArrayList<>( longs ) );
        return elementsById.getContent();
    }

    @Override
    public void addIdToCart( Long id, Long amount, String sessionId ) {

        Element one = elementRepository.findOne( id );
        if ( one == null ) {
            throw new IllegalArgumentException( "No Element with such ID" );
        }
        Set<CartElementDTO> longs = cart.get( sessionId );
        if ( longs == null ) {
            longs = new HashSet<>();
            CartElementDTO e = new CartElementDTO();
            e.setAmount( amount );
            e.setElementId( one.getId() );
            e.setSessionId( sessionId );
            longs.add( e );
        } else {
            Iterator<CartElementDTO> iterator = longs.iterator();
            while ( iterator.hasNext() ) {
                CartElementDTO element = iterator.next();
                if ( element != null && element.getElementId().equals( id ) ) {
                    element.setAmount( element.getAmount() + amount );
                }
            }

//            longs.stream().filter( e -> e.getElementId().equals( id ) ).forEach( e -> e.setAmount( amount ) );
        }
        cart.put( sessionId, longs );
    }

    @Override
    public boolean removeElementFromCart( Long id, String sessionId ) {
        Set<CartElementDTO> longs = cart.get( sessionId );
        Iterator<CartElementDTO> iterator = longs.iterator();
        while ( iterator.hasNext() ) {
            Long elementId = iterator.next().getElementId();
            if ( elementId.equals( id ) ) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

}
