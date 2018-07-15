package com.lgi.theweschshop.shopdata.service;

import com.lgi.theweschshop.shopdata.model.Type;

import java.util.List;

public interface TypeService {

    void saveType( String typeStr );

    Type getType( Long id );

    Type findTypeByTypeName( String typeName );

    Type getDefaultType();


    List<Type> getAllTypes();
}
