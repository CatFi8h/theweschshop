package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.entity.Type;
import com.lgi.theweschshop.shopdata.repository.TypeRepository;
import com.lgi.theweschshop.shopdata.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("typeService")
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public Type saveType( Type type ) {
        Type save = typeRepository.save( type );
        return save;
    }

    @Override
    public Type getType( Long id ) {
        return typeRepository.getOne( id );
    }

    @Override
    public Type findTypeByTypeName( String typeName ) {
        return typeRepository.findTypeByTypeName( typeName );
    }

}
