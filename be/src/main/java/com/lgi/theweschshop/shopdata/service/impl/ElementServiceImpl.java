package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.enums.Gender;
import com.lgi.theweschshop.shopdata.model.Color;
import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.model.SizeEntity;
import com.lgi.theweschshop.shopdata.model.Type;
import com.lgi.theweschshop.shopdata.repository.ColorRepository;
import com.lgi.theweschshop.shopdata.repository.ElementRepository;
import com.lgi.theweschshop.shopdata.repository.SizeEntityRepository;
import com.lgi.theweschshop.shopdata.repository.TypeRepository;
import com.lgi.theweschshop.shopdata.requests.ElementSaveRequestDTO;
import com.lgi.theweschshop.shopdata.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
@Service("elementService")
public class ElementServiceImpl implements ElementService {

    @Autowired
    private ElementRepository elementRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private SizeEntityRepository sizeEntityRepository;


    @Override
    public List<Element> getAllElements() {
        List<Element> allElements = elementRepository.findAll();
        return allElements;
    }

    @Override
    public List<Element> getElementsListByType( Type type, Pageable pageable ) {
        return ( List<Element> ) elementRepository.findAllByType( type );
    }

//    @Override
//    public Element addElement( ElementSaveRequestDTO elementRequest ) {
//        String typeStr = elementRequest.getType();
//        Long amount = elementRequest.getAmount();
//        String colorStr = elementRequest.getColor();
//        String sizeStr = elementRequest.getSize();
//        String description = elementRequest.getDescription();
//        String gender = elementRequest.getGender();
//        String name = elementRequest.getName();
//
//        Type type = typeRepository.findDistinctByName( typeStr );
//        Color color = colorRepository.findDistinctByColorName( colorStr );
//        SizeEntity sizeEntity = sizeEntityRepository.findDistinctByName( sizeStr );
//
//        Element element = new Element();
//        element.setType( type );
//        element.setColor( color );
//        element.setSize( sizeEntity );
//
//        element.setAmount( amount );
//        element.setDescription( description );
//        element.setGender( Gender.valueOf( gender ) );
//        element.setName( name );
//
//        return elementRepository.save( element );
//
//    }

    @Override
    public Optional<Element> getElementById( Number elementId ) {
        return Optional.ofNullable( elementRepository.findOne( elementId.longValue() ) );
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
