package com.usopenblog.usopen_blog_backend_20240515.repository;

import com.usopenblog.usopen_blog_backend_20240515.entity.BoardListViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardListViewRepository extends JpaRepository<BoardListViewEntity, Integer> {
}
