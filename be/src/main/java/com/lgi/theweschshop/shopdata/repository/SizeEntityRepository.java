package com.lgi.theweschshop.shopdata.repository;

import com.lgi.theweschshop.shopdata.model.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeEntityRepository extends JpaRepository<SizeEntity, Long> {
    SizeEntity findDistinctBySize( String size );
}
