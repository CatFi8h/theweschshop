package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.dao.UserDAO;
import com.lgi.theweschshop.shopdata.entity.User;
import com.lgi.theweschshop.shopdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public Optional<User> getUserById( String id ) {
        Optional<User> user = userDAO.find( id );
        return user;
    }

    @Override
    @Transactional
    public void addUser( String email, String userName, String password ) {
        User user = new User( email, userName, password );
        userDAO.persist( user );
    }

    @Override
    public List<User> getUserList() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void delete( User user ) {
        userDAO.remove( user );
    }


}