package com.lgi.theweschshop.shopdata.dao.Impl;

import com.lgi.theweschshop.shopdata.dao.AbstractGenericDAO;
import com.lgi.theweschshop.shopdata.dao.UserDAO;
import com.lgi.theweschshop.shopdata.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
@Repository
public class UserDAOImpl extends AbstractGenericDAO<User> implements UserDAO {

    public List<User> getAllUsers() {
        Query query = entityManager.createQuery( "select u from User u" );
        List<User> list = query.getResultList();
        return list;
    }



}
