//package com.lgi.theweschshop.shopdata.controller;
//
//import com.lgi.theweschshop.shopdata.service.ColorService;
//import com.lgi.theweschshop.shopdata.service.ElementService;
//import com.lgi.theweschshop.shopdata.service.TypeService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.junit.Assert.assertTrue;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
///**
// * Created by Igor Yurchenko on 11/15/17.
// */
//@WebMvcTest(value = ElementController.class, secure = false)
//@RunWith(SpringRunner.class)
//public class ElementControllerTest {
//
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    private ElementService elementService;
//
//    @Autowired
//    private TypeService typeService;
//
//    @MockBean
//    private ColorService colorService;
//
//    @Test
//    public void test() {
//
//        try {
//            mvc.perform( MockMvcRequestBuilders.get( "/shop" )
//                    .param( "", null )
//                    .contentType( MediaType.APPLICATION_JSON ) ).andExpect( status().isOk() )
//            .andExpect( view().name( "/shop" ) );
//        } catch ( Exception e ) {
//            assertTrue( false );
//        }
//    }
//
//}