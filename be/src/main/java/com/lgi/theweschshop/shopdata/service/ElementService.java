package com.lgi.theweschshop.shopdata.service;

import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.model.Type;
import com.lgi.theweschshop.shopdata.requests.ElementSaveRequestDTO;
import com.lgi.theweschshop.shopdata.response.dto.ElementResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
public interface ElementService {

    List<Element> getAllElements( );

    List<ElementResponse> getAllElementsResponse();

    List<Element> getElementsListByType( Type type, Pageable pageable );

    Element save( ElementSaveRequestDTO elementRequest );

    Optional<ElementResponse> getElementById(Number elementId );

    void delete( Element element );

    @Transactional
    void delete( Long id );

}
