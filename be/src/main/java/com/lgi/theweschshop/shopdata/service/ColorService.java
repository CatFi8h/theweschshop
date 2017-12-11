package com.lgi.theweschshop.shopdata.service;

import com.lgi.theweschshop.shopdata.entity.Color;

public interface ColorService {
    Color saveColor( Color color );

    Color getColorById( Long id );
}
