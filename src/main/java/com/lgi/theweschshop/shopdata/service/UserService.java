package com.lgi.theweschshop.shopdata.service;

import com.lgi.theweschshop.shopdata.entity.EUser;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
public interface UserService {

    Optional<EUser> getUserByEmail( String email );

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    void addUser( String email, String userName, String password );

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    List<EUser> getUserList();

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    void delete( EUser user );

}
