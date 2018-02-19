package com.lgi.theweschshop.shopdata.repository;

import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

/**
 * Created by Igor Yurchenko on 11/8/17.
 */

public interface ElementRepository extends JpaRepository<Element, Long>, JpaSpecificationExecutor<Element> {

    Collection<Element> findAllByType( Type type );


    @Query("select e from Element e left join e.comments where e.id = :id ")
    Element findElementById( @Param("id") Long id );
}
