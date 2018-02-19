package com.lgi.theweschshop.shopdata.repository;

import com.lgi.theweschshop.shopdata.enums.Gender;
import com.lgi.theweschshop.shopdata.enums.Size;
import com.lgi.theweschshop.shopdata.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElementRepositoryTest {

    @Autowired
    ElementRepository elementRepository;

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    SizeEntityRepository sizeEntityRepository;

    @Autowired
    PictureRepository pictureRepository;

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void testRunr() {

        Type shirtType = new Type();
        shirtType.setName( "shirt" );
        typeRepository.save( shirtType );

        SizeEntity size = new SizeEntity();
        size.setSize( Size.S.name() );
        sizeEntityRepository.save( size );


        Element element = new Element();
        element.setSize( size );
        element.setDescription( "blabla" );
        element.setName( "My Test Shirt" );
        element.setType( shirtType );
        element.setGender( Gender.male.name() );
        element.setAmount( 1 );
        element.setCreationDate( new Date() );

        Comment comment = new Comment();
        comment.setComment( "First Comment" );
        comment.setEmail( "test@mail.ru" );
        comment.setName( "Lilu Dalas" );
        comment.setElement( element );

        Picture picture = new Picture();
        picture.setPictureName( "my picture" );
        picture.setPicture( new byte[256] );

//        element.setPicture( new HashSet<>( Arrays.asList( picture ) ) );
        element.setComments( Collections.singletonList( comment ) );

        elementRepository.save( element );
        pictureRepository.save( picture );
        commentRepository.save( comment );


        Collection<Element> allByType = elementRepository.findAllByType( shirtType );

        assertNotNull( allByType );
        assertEquals( 1, allByType.size() );
        Element next = allByType.iterator().next();
        assertNotNull( next );

    }

}