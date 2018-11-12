package com.lgi.theweschshop.shopdata.repository;

import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

/**
 * Created by Igor Yurchenko on 11/8/17.
 */

public interface ElementRepository extends JpaRepository<Element, Long>, JpaSpecificationExecutor<Element> {

    Collection<Element> findAllByType( Type type );

    @Query("select e from Element e " +
            "join fetch e.elementSizeAmounts s " +
            "join fetch e.type " +
            "where e.isDeleted = false")
    List<Element> findAll();


    @Query("select e from Element e where e.id = :id and e.isDeleted = false")
    Element findElementById( @Param("id") Long id );


    @Query("select e from Element e where e.id in :ids and e.isDeleted = false")
    Page<Element> findElementsById( Pageable pageable, @Param("ids") List<Long> ids );

    @Query("update Element e set e.isDeleted = true where e.id = :id")
    Element deleteElement( @Param("id") Long id );

    @Query("select e from Element e join fetch e.elementSizeAmounts s where e.id = :id and e.isDeleted = false")
    Element findElementByIdAndSize( @Param("id") Long id );
}
