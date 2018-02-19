package com.lgi.theweschshop.shopdata.service;

import com.lgi.theweschshop.shopdata.model.SizeEntity;
import com.lgi.theweschshop.shopdata.response.dto.SizeDTO;

import java.util.List;

public interface SizeEntityService {
    List<SizeEntity> getAllSize();

    void saveSize( String size );
}
