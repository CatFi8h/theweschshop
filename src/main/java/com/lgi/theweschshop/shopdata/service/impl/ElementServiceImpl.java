package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.dao.ElementDAO;
import com.lgi.theweschshop.shopdata.entity.Element;
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
    private ElementDAO elementDAO;

    @Override
    public List<Element> getAllElements() {
        List<Element> allElements = elementDAO.findAllElements();
        return allElements;
    }

    @Override
    @Transactional
    public void addElement( String elementName, String description ) {
        Element element = new Element( elementName, description );
        elementDAO.persist( element );

    }

    @Override
    public Optional<Element> getElementById( Integer elementId ) {
        return elementDAO.find( elementId );
    }

    @Override
    @Transactional
    public void delete( Element element ) {
        elementDAO.remove( element );
    }

}
