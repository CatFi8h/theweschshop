//package com.lgi.theweschshop.shopdata.security;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
///**
// * Created by Igor Yurchenko on 11/2/17.
// */
//public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
//
//    public CustomLoginSuccessHandler( String url ) {
//        setDefaultTargetUrl( url );
//    }
//
//    @Override
//    public void onAuthenticationSuccess( HttpServletRequest request,
//                                         HttpServletResponse response, Authentication authentication )
//            throws ServletException, IOException {
//
//        HttpSession session = request.getSession();
//        if ( session != null ) {
//            String redirectUrl = ( String ) session.getAttribute( "url_prior_login" );
//            if ( redirectUrl != null ) {
//                session.removeAttribute( "url_prior_login" );
//                getRedirectStrategy().sendRedirect( request, response, redirectUrl );
//            } else {
//                super.onAuthenticationSuccess( request, response, authentication );
//            }
//        } else {
//            super.onAuthenticationSuccess( request, response, authentication );
//        }
//    }
//}
