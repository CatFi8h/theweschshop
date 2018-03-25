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
        PageRequest pageRequest = new PageRequest( pageNumber - 1, 10, Sort.Direction.ASC, sortType );
        Set<CartElementDTO> cartElementDTOS = cart.get( sessionId );
        if ( cartElementDTOS == null ) {
            cartElementDTOS = new HashSet<>();
        }
        Set<Long> longs = cartElementDTOS.stream().map( CartElementDTO::getElementId ).collect( Collectors.toSet() );

        Page<Element> elementsById = elementRepository.findElementsById( pageRequest, new ArrayList<>( longs ) );
        return elementsById.getContent();
    }

    @Override
    public void addIdToCart( Long id, Long amount, String sessionId ) {
        Set<CartElementDTO> longs = cart.get( sessionId );
        if ( longs == null ) {
            longs = new HashSet<>();
        }
        longs.stream().filter( e -> e.getElementId().equals( id ) ).forEach( e->e.setAmount( amount ) );
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
