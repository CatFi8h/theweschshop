package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.enums.Gender;
import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.model.SizeEntity;
import com.lgi.theweschshop.shopdata.model.Type;
import com.lgi.theweschshop.shopdata.repository.ElementRepository;
import com.lgi.theweschshop.shopdata.repository.SizeEntityRepository;
import com.lgi.theweschshop.shopdata.repository.TypeRepository;
import com.lgi.theweschshop.shopdata.requests.ElementSaveRequestDTO;
import com.lgi.theweschshop.shopdata.response.dto.ElementResponse;
import com.lgi.theweschshop.shopdata.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
@Service("elementService")
public class ElementServiceImpl implements ElementService {

    @Autowired
    private ElementRepository elementRepository;

    @Autowired
    private TypeRepository typeRepository;

    private Map<String, Set<Long>> cart = new HashMap<>();

    @Autowired
    private SizeEntityRepository sizeEntityRepository;

    @Override
    public List<Element> getAllElements() {
        List<Element> allElements = elementRepository.findAll();
        return allElements;
    }

    @Override
    public List<ElementResponse> getAllElementsResponse() {
        List<Element> allElements = elementRepository.findAll();
        List<ElementResponse> objects = new ArrayList<>();
        for ( Element element : allElements ) {
            ElementResponse elementResponse = new ElementResponse( element );
            objects.add( elementResponse );
        }
        return objects;
    }

    @Override
    public List<Element> getElementsListByType( Type type, Pageable pageable ) {
        return ( List<Element> ) elementRepository.findAllByType( type );
    }

    @Override
    public Element save( ElementSaveRequestDTO elementRequest ) {
        String typeStr = elementRequest.getType();
        Long amount = elementRequest.getAmount();
        String sizeStr = elementRequest.getSize();
        String description = elementRequest.getDescription();
        String gender = elementRequest.getGender();
        String name = elementRequest.getName();
        Double price = elementRequest.getPrice();

        Type type = typeRepository.findDistinctByName( typeStr );
        SizeEntity sizeEntity = sizeEntityRepository.findDistinctBySize( sizeStr );

        Element element = new Element();
        element.setType( type );
        element.setSize( sizeEntity );

        element.setAmount( amount.intValue() );
        element.setDescription( description );
        element.setGender( Gender.valueOf( gender ).name() );
        element.setName( name );

        BigDecimal bigDecimal = new BigDecimal( price );
        element.setPrice( bigDecimal.setScale( 2, BigDecimal.ROUND_DOWN ).doubleValue() );
        element.setCreationDate( new Date( System.currentTimeMillis() ) );

        return elementRepository.save( element );

    }

    @Override
    public Optional<Element> getElementById( Number elementId ) {
        return Optional.ofNullable( elementRepository.findElementById( elementId.longValue() ) );
    }

    @Override
    @Transactional
    public void delete( Element element ) {
        elementRepository.delete( element );
    }

    @Override
    @Transactional
    public void delete( Long id ) {
        elementRepository.delete( id );
    }
}
