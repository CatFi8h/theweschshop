package com.lgi.theweschshop.shopdata.repository;

import com.lgi.theweschshop.shopdata.enums.Gender;
import com.lgi.theweschshop.shopdata.enums.Size;
import com.lgi.theweschshop.shopdata.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
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

    @Autowired
    ElementSizeAmountRepository elementSizeAmountRepository;

    @Test
    public void testRunr() {

        Type shirtType = new Type();
        shirtType.setName( "shirt" );
        typeRepository.save( shirtType );

        SizeEntity size = new SizeEntity();
        size.setName( Size.S.name() );
        sizeEntityRepository.save( size );


        Element element = new Element();
        element.setDescription( "blabla" );
        element.setName( "My Test Shirt" );
        element.setType( shirtType );
        element.setGender( Gender.male.name() );
        element.setCreationDate( new Date() );
        BigDecimal bigDecimal = new BigDecimal( 150.0 );
        bigDecimal.setScale( 0, RoundingMode.HALF_UP );
        element.setPrice( bigDecimal.doubleValue() );

        ElementSizeAmount elementSizeAmount = new ElementSizeAmount();
        elementSizeAmount.setAmount( 1 );
        elementSizeAmount.setSize( size );
        elementSizeAmount.setElement( element );
        elementSizeAmountRepository.save( elementSizeAmount );

        element.setElementSizeAmounts( new HashSet<>( Arrays.asList( elementSizeAmount ) ) );

        Comment comment = new Comment();
        comment.setComment( "First Comment" );
        comment.setEmail( "test@mail.ru" );
        comment.setName( "Lilu Dalas" );
        comment.setElement( element );
        comment.setCreationDate( Date.from( LocalDateTime.now().atZone( ZoneId.systemDefault() ).toInstant() ) );

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


    @Test
    public void test() {

        Type shirtType = new Type();
        shirtType.setName( "shirt" );
        typeRepository.save( shirtType );

        SizeEntity size = new SizeEntity();
        size.setName( Size.S.name() );

        Element element = new Element();
        element.setDescription( "blabla" );
        element.setName( "My Test Shirt" );
        element.setType( shirtType );
        element.setGender( Gender.male.name() );
        element.setCreationDate( new Date() );
        element.setPrice( 100.0 );
        element.setIsDeleted( false );

        ElementSizeAmount elementSizeAmount = new ElementSizeAmount();
        elementSizeAmount.setElement( element );
        elementSizeAmount.setSize( size );
        elementSizeAmount.setAmount( 1 );

        element.setElementSizeAmounts( new HashSet<>( Arrays.asList( elementSizeAmount ) ) );

        Comment comment = new Comment();
        comment.setComment( "First Comment" );
        comment.setEmail( "test@mail.ru" );
        comment.setName( "Lilu Dalas" );
        comment.setElement( element );
        comment.setCreationDate( new Date() );

        Picture picture = new Picture();
        picture.setPictureName( "my picture" );
        picture.setPicture( new byte[256] );

//        element.setPicture( new HashSet<>( Arrays.asList( picture ) ) );
        element.setComments( Collections.singletonList( comment ) );

        sizeEntityRepository.save( size );
        pictureRepository.save( picture );
        commentRepository.save( comment );
        elementRepository.save( element );
        elementSizeAmountRepository.save( elementSizeAmount );


        Element elementByIdAndSize = elementRepository.findElementByIdAndSize( element.getId() );
        assertNotNull( elementByIdAndSize );
    }

}