package com.usopenblog.usopen_blog_backend_20240515.repository;

import com.usopenblog.usopen_blog_backend_20240515.entity.SearchLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchLogRepository extends JpaRepository<SearchLogEntity, Integer> {

}
