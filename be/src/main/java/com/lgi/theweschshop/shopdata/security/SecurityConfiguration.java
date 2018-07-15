//package com.lgi.theweschshop.shopdata.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationTrustResolver;
//import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
// * Created by Igor Yurchenko on 10/31/17.
// */
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    UserDetailsService userDetailsService;
//
//    @Autowired
//    public void configureGlobalSecurity( AuthenticationManagerBuilder auth ) throws Exception {
//        auth.userDetailsService( userDetailsService );
//        auth.authenticationProvider( authenticationProvider() );
//    }
//
//    @Override
//    protected void configure( HttpSecurity http ) throws Exception {
//
//        http
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();
//
//
////        http
////                .authorizeRequests()
////                .antMatchers( "/",
////                        "/index", "/shop", "/element/**", "/admins",
////                        "/admin_element",
////                        "/style/**", "/css/**" ).permitAll()
////                .anyRequest().authenticated()
////                .and()
////                .formLogin().loginPage( "/login" )
////                .permitAll().and().logout().permitAll();
//
//
////        http.authorizeRequests().antMatchers("/", "/user/list")
////                .access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
////                .antMatchers("/element/**").access("hasRole('ADMIN')")
////                .and().formLogin().loginPage("/login")
////                .loginProcessingUrl("/login").usernameParameter("ssoId").passwordParameter("password").and()
////                .rememberMe().rememberMeParameter("remember-me").tokenRepository(tokenRepository)
////                .tokenValiditySeconds(20*60).and().csrf().and().exceptionHandling().accessDeniedPage("/access_denied");
//
//
////        http.authorizeRequests().antMatchers("/", "/user/list")
////                .access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
////                .antMatchers("/newuser/**", "/delete-user-*").access("hasRole('ADMIN')").antMatchers("/edit-user-*")
////                .access("hasRole('ADMIN') or hasRole('DBA')").and().formLogin().loginPage("/login")
////                .loginProcessingUrl("/login").usernameParameter("ssoId").passwordParameter("password").and()
////                .rememberMe().rememberMeParameter("remember-me").tokenRepository(tokenRepository)
////                .tokenValiditySeconds(20*60).and().csrf().and().exceptionHandling().accessDeniedPage("/access_denied");
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService( userDetailsService );
//        authenticationProvider.setPasswordEncoder( passwordEncoder() );
//        return authenticationProvider;
//    }
//
//    @Bean
//    public AuthenticationTrustResolver getAuthenticationTrustResolver() {
//        return new AuthenticationTrustResolverImpl();
//    }
//
//}
