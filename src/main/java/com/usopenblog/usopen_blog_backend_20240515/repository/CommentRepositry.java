package com.usopenblog.usopen_blog_backend_20240515.repository;

import com.usopenblog.usopen_blog_backend_20240515.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepositry extends JpaRepository<CommentEntity, Integer> {


}
