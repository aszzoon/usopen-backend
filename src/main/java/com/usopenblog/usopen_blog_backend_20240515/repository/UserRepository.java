package com.usopenblog.usopen_blog_backend_20240515.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usopenblog.usopen_blog_backend_20240515.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {



}