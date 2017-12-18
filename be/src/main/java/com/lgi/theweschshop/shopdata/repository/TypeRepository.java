package com.lgi.theweschshop.shopdata.repository;

import com.lgi.theweschshop.shopdata.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface TypeRepository extends JpaRepository<Type, Long> {


    public Type findDistinctByName(  String typeName );



}
