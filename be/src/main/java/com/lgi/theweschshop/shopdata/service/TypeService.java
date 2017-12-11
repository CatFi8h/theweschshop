package com.lgi.theweschshop.shopdata.service;

import com.lgi.theweschshop.shopdata.entity.Type;

public interface TypeService {
    Type saveType( Type type );

    Type getType( Long id );

    Type findTypeByTypeName( String typeName );
}
