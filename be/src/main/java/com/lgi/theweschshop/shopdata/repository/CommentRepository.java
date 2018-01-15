package com.lgi.theweschshop.shopdata.repository;

import com.lgi.theweschshop.shopdata.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
