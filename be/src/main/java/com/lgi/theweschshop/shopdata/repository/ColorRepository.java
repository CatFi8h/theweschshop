package com.lgi.theweschshop.shopdata.repository;

import com.lgi.theweschshop.shopdata.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Long> {

    public Color findDistinctByColorName( String name );
}
