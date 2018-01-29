package com.lgi.theweschshop.shopdata.repository;

import com.lgi.theweschshop.shopdata.model.Color;
import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.model.Type;
import com.lgi.theweschshop.shopdata.enums.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Collection;

/**
 * Created by Igor Yurchenko on 11/8/17.
 */

public interface ElementRepository extends JpaRepository<Element, Long>, JpaSpecificationExecutor<Element> {

     Collection<Element> findAllByColorAndSizeAndType( Color color, Size size, Type type );

     Collection<Element> findAllByType( Type type );

}
