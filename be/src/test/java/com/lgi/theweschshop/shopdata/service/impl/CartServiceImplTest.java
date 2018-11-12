//package com.lgi.theweschshop.shopdata.service.impl;
//
//import com.lgi.theweschshop.shopdata.repository.ElementRepository;
//import com.lgi.theweschshop.shopdata.service.CartService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//import static org.mockito.Mockito.when;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class CartServiceImplTest {
//
//    @MockBean
//    ElementRepository elementRepository;
//
//    @Autowired
//    CartService cartService;
//
//    @Test
//    public void test() {
//        when( elementRepository.findElementsById(
//                new PageRequest( 1, 10 ),
//                new ArrayList<>( Arrays.asList( 1L, 2L, 3L ) ) ) ).thenAnswer( null );
//    }
//}