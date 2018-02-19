//package com.lgi.theweschshop.shopdata.security;
//
//import com.lgi.theweschshop.shopdata.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * Created by Igor Yurchenko on 11/2/17.
// */
//@Service("UserDetailsService")
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    @Transactional(readOnly = true)
//    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
////        EUser user = userService.getUserByEmail( username ).orElseThrow( () -> new UsernameNotFoundException( username ) );
////        UserRole userRole = user.getUserRole();
////        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority( userRole.name() );
////        List<SimpleGrantedAuthority> authorities = Collections.singletonList( simpleGrantedAuthority );
////        return new org.springframework.security.core.userdetails.User( user.getName(), user.getPassword(), authorities );
//        return null;
//    }
//}
