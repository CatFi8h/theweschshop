package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.model.Type;
import com.lgi.theweschshop.shopdata.repository.TypeRepository;
import com.lgi.theweschshop.shopdata.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("typeService")
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public void saveType( String typeStr ) {
        Type type = new Type();
        type.setName( typeStr );

        typeRepository.save( type );
    }

    @Override
    public Type getType( Long id ) {
        return typeRepository.getOne( id );
    }

    @Override
    public Type findTypeByTypeName( String typeName ) {
        return typeRepository.findDistinctByName( typeName );
    }

    @Override
    public Type getDefaultType() {
        return typeRepository.findOne( 0L );
    }

    @Override
    public List<Type> getAllTypes() {
        return typeRepository.findAll();

    }

}
