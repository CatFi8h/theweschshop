package com.lgi.theweschshop.shopdata.repository;

import com.lgi.theweschshop.shopdata.enums.Size;
import com.lgi.theweschshop.shopdata.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ElementRepositoryTest {

    @Autowired
    ElementRepository elementRepository;

    @Autowired
    ColorRepository colorRepository;

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

//        Color green = new Color( "green", "#00000" );
//        colorRepository.save( green );

        Type shirtType = new Type( "shirt" );
        typeRepository.save( shirtType );

//        SizeEntity size = new SizeEntity( Size.S );
//        sizeEntityRepository.save( size );



        Element element = new Element();
//        element.setColor( green );
//        element.setSize( size );
        element.setDescription( "blabla" );
        element.setName( "My Test Shirt" );
//        element.setType( shirtType );

        Comment comment = new Comment();
        comment.setComment( "First Comment" );
        comment.setEmail( "test@mail.ru" );
        comment.setName( "Lilu Dalas" );
        comment.setElement( element );

        Picture picture = new Picture();
        picture.setPictureName( "my pictyre" );
        picture.setPicture( new byte[256] );

//        element.setPicture( new HashSet<>( Arrays.asList( picture ) ) );
        element.setComment( new ArrayList<>( Arrays.asList( comment ) ) );

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