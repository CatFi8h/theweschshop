package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.dao.UserDAO;
import com.lgi.theweschshop.shopdata.entity.User;
import com.lgi.theweschshop.shopdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public Optional<User> getUserById( String id ) {
        Optional<User> user = userDAO.find( id );
        return user;
    }

    @Override
    public void addUser( User user ) {
        userDAO.persist( user );
    }

    public void removeUser( User user ) {
        userDAO.remove( user );
    }


}
