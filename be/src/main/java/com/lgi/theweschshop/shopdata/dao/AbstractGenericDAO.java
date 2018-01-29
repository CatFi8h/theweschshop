//package com.lgi.theweschshop.shopdata.dao;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.io.Serializable;
//import java.lang.reflect.ParameterizedType;
//import java.util.Optional;
//
///**
// * Created by Igor Yurchenko on 10/26/17.
// */
//public abstract class AbstractGenericDAO<T> implements GenericDAO<T> {
//
//    @PersistenceContext
//    protected EntityManager entityManager;
//
//    private final Class<T>persistentClass;
//
//    protected AbstractGenericDAO(  ) {
//        this.persistentClass = ( Class<T> ) ( ( ParameterizedType ) getClass().getGenericSuperclass() ).getActualTypeArguments()[0];
//    }
//
//    @Override
//    public Optional<T> find( Serializable id ) {
//        return Optional.ofNullable( entityManager.find( this.persistentClass, id ) );
//    }
//
//    @Override
//    public void persist( T model ) {
//        entityManager.persist( model );
//    }
//
//    @Override
//    public T merge( T model ) {
//        return entityManager.merge( model );
//    }
//
//    @Override
//    public void remove( T model ) {
//        entityManager.remove( model );
//    }
//}
