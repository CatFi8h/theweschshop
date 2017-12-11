package com.lgi.theweschshop.shopdata.service;

import com.lgi.theweschshop.shopdata.entity.Element;
import com.lgi.theweschshop.shopdata.entity.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
public interface ElementService {

    List<Element> getAllElements();

    List<Element> getElementsListByType( Type type, Pageable pageable );

    Element addElement( String elementName, String description );

    Optional<Element> getElementById( Number elementId );

    void delete( Element element );

    @Transactional
    void delete( Long id );

}
