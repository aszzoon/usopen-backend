package com.usopen.backend.repository;

import com.usopen.backend.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepositry extends JpaRepository<CommentEntity, Integer> {


}
