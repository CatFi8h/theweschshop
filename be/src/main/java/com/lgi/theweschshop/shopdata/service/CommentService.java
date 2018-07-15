package com.lgi.theweschshop.shopdata.service;

import com.lgi.theweschshop.shopdata.requests.CommentRequestDTO;

public interface CommentService {
    void saveComment( CommentRequestDTO commentRequestDTO );
}
