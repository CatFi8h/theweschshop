package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.entity.Element;
import com.lgi.theweschshop.shopdata.repository.ElementRepository;
import com.lgi.theweschshop.shopdata.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public List<Element> getAllElements() {
        List<Element> allElements = elementRepository.findAll();
        return allElements;
    }

    @Override
    @Transactional
    public void addElement( String elementName, String description ) {
        Element element = new Element( elementName, description );
        elementRepository.save( element );

    }

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
