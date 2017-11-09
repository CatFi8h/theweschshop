package com.lgi.theweschshop.shopdata.repository;

import com.lgi.theweschshop.shopdata.domain.Size;
import com.lgi.theweschshop.shopdata.entity.Color;
import com.lgi.theweschshop.shopdata.entity.Element;
import com.lgi.theweschshop.shopdata.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Collection;

/**
 * Created by Igor Yurchenko on 11/8/17.
 */

public interface ElementRepository extends JpaRepository<Element, Long>, JpaSpecificationExecutor<Element> {

    public Collection<Element> findAllByColorAndSizeEntitiesAndColor( Color color, Size size, Type type );

}
