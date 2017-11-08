package com.lgi.theweschshop.shopdata.repository;

import com.lgi.theweschshop.shopdata.entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

/**
 * Created by Igor Yurchenko on 11/8/17.
 */

public interface ElementRepository extends JpaRepository<Element, Long>, JpaSpecificationExecutor<Element> {



    @Query("select e from Element e where ")
    public Collection<Element> findAllByColorAndSizeEntitiesAndType();

}
