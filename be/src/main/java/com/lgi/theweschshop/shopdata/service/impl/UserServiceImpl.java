package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.model.EUser;
import com.lgi.theweschshop.shopdata.repository.UserRepository;
import com.lgi.theweschshop.shopdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<EUser> getUserByEmail( String email ) {
        Optional<EUser> user = Optional.ofNullable( userRepository.findEUserByEmail( email ) );
        return user;
    }

    @Override
    @Transactional
    public void addUser( String email, String userName, String surname, String password ) {
        EUser user = new EUser( email, userName, password );
        userRepository.save( user );
    }

    @Override
    public List<EUser> getUserList() {
        return userRepository.findAll();
    }

//    @Override
//    @Transactional
//    public void delete( String email ) {
//        Optional<EUser> userById = getUserByEmail( email );
//        EUser user = userById.orElseThrow( NoSuchElementException::new );
//        user.setIsDeleted( true );
//        userRepository.save( user );
//
//    }

}