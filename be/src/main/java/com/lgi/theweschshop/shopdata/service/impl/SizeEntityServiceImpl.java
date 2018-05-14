package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.model.SizeEntity;
import com.lgi.theweschshop.shopdata.repository.SizeEntityRepository;
import com.lgi.theweschshop.shopdata.service.SizeEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sizeService")
public class SizeEntityServiceImpl implements SizeEntityService {

    @Autowired
    public SizeEntityRepository sizeEntityRepository;

    @Override
    public List<SizeEntity> getAllSize() {
        return sizeEntityRepository.findAll();
    }

    @Override
    public void saveSize( String size ) {

        SizeEntity sizeEntity = new SizeEntity();
        sizeEntity.setName( size );

        sizeEntityRepository.save( sizeEntity );
    }

}
