//package com.lgi.theweschshop.shopdata.dao.Impl;
//
//import com.lgi.theweschshop.shopdata.dao.AbstractGenericDAO;
//import com.lgi.theweschshop.shopdata.dao.UserDAO;
//import com.lgi.theweschshop.shopdata.model.EUser;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.Query;
//import java.util.List;
//
///**
// * Created by Igor Yurchenko on 10/26/17.
// */
//@Repository
//public class UserDAOImpl extends AbstractGenericDAO<EUser> implements UserDAO {
//
//    @Override
//    public List<EUser> getAllUsers() {
//        Query query = entityManager.createQuery( "select u from User u" );
//        List<EUser> list = query.getResultList();
//        return list;
//    }
//
//}
