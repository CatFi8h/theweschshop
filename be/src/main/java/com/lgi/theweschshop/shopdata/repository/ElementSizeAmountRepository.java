package com.lgi.theweschshop.shopdata.repository;

import com.lgi.theweschshop.shopdata.model.ElementSizeAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ElementSizeAmountRepository extends JpaRepository<ElementSizeAmount, Long> {

    @Query("select e from ElementSizeAmount e join fetch e.element el join fetch e.size s where el.id = :elementId and s.id = :sizeId")
    ElementSizeAmount findByElementAndSize( @Param("elementId") Long elementId, @Param("sizeId") Long sizeId );

}
