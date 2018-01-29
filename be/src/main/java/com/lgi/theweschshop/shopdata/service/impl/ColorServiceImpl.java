package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.model.Color;
import com.lgi.theweschshop.shopdata.repository.ColorRepository;
import com.lgi.theweschshop.shopdata.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;

public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public Color saveColor( Color color ) {
        return colorRepository.save( color );
    }

    @Override
    public Color getColorById( Long id ) {
        return colorRepository.findOne( id );
    }
}
