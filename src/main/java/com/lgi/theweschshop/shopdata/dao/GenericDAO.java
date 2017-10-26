package com.lgi.theweschshop.shopdata.dao;

import java.io.Serializable;
import java.util.Optional;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
public interface GenericDAO<T> {

    Optional<T> find( Serializable id );

    void persist( T entity );

    T merge( T entity );

    void remove( T entity );

}
