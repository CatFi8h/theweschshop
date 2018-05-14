package com.lgi.theweschshop.shopdata.repository;

import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.model.ElementSizeAmount;
import com.lgi.theweschshop.shopdata.model.SizeEntity;
import com.lgi.theweschshop.shopdata.model.Type;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class ElementRepositoryTestIT {

    @Autowired
    ElementRepository elementRepository;

    @Test
    public void test() {

        Element entity = new Element();
        entity.setName( "Name" );
        entity.setGender( "Male" );
        entity.setCreationDate( new Date() );
        SizeEntity size = new SizeEntity();
        size.setName( "LL" );
        entity.setPrice( 2.0 );

        ElementSizeAmount elementSizeAmount = new ElementSizeAmount();
        elementSizeAmount.setAmount( 1 );
        elementSizeAmount.setSize( size );
        elementSizeAmount.setElement( entity );
        Type type = new Type();
        type.setName( "type" );
        entity.setType( type );

        elementRepository.save( entity );

        Page<Element> elementsById = elementRepository.findElementsById( new PageRequest( 0, 10 ),
                new ArrayList<>( Arrays.asList( 1L, 2L, 3L, entity.getId() ) ) );
        List<Element> content = elementsById.getContent();

        Iterator<Element> iterator = content.iterator();

        assertTrue( iterator.hasNext() );

    }
}