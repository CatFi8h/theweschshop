package com.lgi.theweschshop.shopdata.repository;

import com.lgi.theweschshop.shopdata.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {


    public Type findDistinctByName(  String typeName );



}
