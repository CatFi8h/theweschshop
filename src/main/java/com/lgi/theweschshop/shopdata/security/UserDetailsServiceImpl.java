package com.lgi.theweschshop.shopdata.security;

import com.lgi.theweschshop.shopdata.entity.User;
import com.lgi.theweschshop.shopdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Igor Yurchenko on 11/2/17.
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
        User user = userService.getUserById( username ).orElseThrow( NoSuchElementException::new );
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority( user.getUserRole().name() );
        List<SimpleGrantedAuthority> authorities = Collections.singletonList( simpleGrantedAuthority );
        return new org.springframework.security.core.userdetails.User( user.getName(), user.getPassword(), authorities );
    }
}
