package com.lgi.theweschshop.shopdata.service;

import com.lgi.theweschshop.shopdata.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
public interface UserService {

    Optional<User> getUserById( String id );

    void addUser( String email, String userName, String password );

    List<User> getUserList();

    void delete( User user );
}
