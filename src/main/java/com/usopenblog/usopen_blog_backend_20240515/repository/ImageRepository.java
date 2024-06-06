package com.usopenblog.usopen_blog_backend_20240515.repository;

import com.usopenblog.usopen_blog_backend_20240515.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
}
