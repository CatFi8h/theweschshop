package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.model.Comment;
import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.repository.CommentRepository;
import com.lgi.theweschshop.shopdata.repository.ElementRepository;
import com.lgi.theweschshop.shopdata.requests.CommentRequestDTO;
import com.lgi.theweschshop.shopdata.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ElementRepository elementRepository;

    @Override
    public void saveComment( CommentRequestDTO commentRequestDTO ) {
        Comment entity = new Comment();
        Long elementId = commentRequestDTO.getId();
        entity.setElementId( elementId );
        entity.setName( commentRequestDTO.getName() );
        entity.setEmail( commentRequestDTO.getEmail() );
        entity.setComment( commentRequestDTO.getComment() );
        commentRepository.save( entity );
    }
}
