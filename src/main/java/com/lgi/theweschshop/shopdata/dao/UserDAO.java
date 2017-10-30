package com.lgi.theweschshop.shopdata.dao;

import com.lgi.theweschshop.shopdata.entity.User;

import java.util.List;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
public interface UserDAO extends GenericDAO<User> {

    List<User> getAllUsers();
}
