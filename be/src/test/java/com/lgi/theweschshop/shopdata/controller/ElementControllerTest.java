package com.lgi.theweschshop.shopdata.controller;

import com.lgi.theweschshop.shopdata.entity.Color;
import com.lgi.theweschshop.shopdata.entity.Element;
import com.lgi.theweschshop.shopdata.entity.SizeEntity;
import com.lgi.theweschshop.shopdata.entity.Type;
import com.lgi.theweschshop.shopdata.enums.Gender;
import com.lgi.theweschshop.shopdata.enums.Size;
import com.lgi.theweschshop.shopdata.service.ElementService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Igor Yurchenko on 11/15/17.
 */
@WebMvcTest(value = ElementController.class)
@RunWith(SpringRunner.class)
public class ElementControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private ElementService service;

    @Test
    public void getElementListTest() throws Exception {

        Element element = new Element( "Shirt Bear", "Shirt with teddy bear", new Type( "Shirt" ),
                new Color( "white" ), new SizeEntity( Size.XL ), Gender.male );
        List<Element> elements = new ArrayList<>();
        elements.add( element );

        given( service.getAllElements() ).willReturn( elements );
        mvc.perform( get( "/element/list" )
                .contentType( MediaType.APPLICATION_JSON ) )
                .andExpect( status().isOk() )
                .andExpect( jsonPath( "$", hasSize( 1 ) ) );
    }

}