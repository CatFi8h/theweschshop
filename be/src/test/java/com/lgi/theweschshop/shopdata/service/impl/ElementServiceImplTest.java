package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.requests.ElementSaveRequestDTO;
import com.lgi.theweschshop.shopdata.service.ElementService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ElementServiceImplTest {

    @Autowired
    private ElementService elementService;

    @Test
    public void test() {

        ElementSaveRequestDTO elementRequest = new ElementSaveRequestDTO();

//        elementRequest.setAmount( 1L );
//        elementRequest.setColor( "White" );
//        elementRequest.setAmount( 10L );
//        elementRequest.setName( "Test" );
//        elementRequest.setDescription( "discription" );
//        elementRequest.setGender( "male" );
//        elementRequest.setSize( "XL" );


//        Element element = elementService.addElement( elementRequest );


    }
}