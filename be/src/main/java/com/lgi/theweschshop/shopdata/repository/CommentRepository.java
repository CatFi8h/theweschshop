package com.lgi.theweschshop.shopdata.repository;

import com.lgi.theweschshop.shopdata.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
