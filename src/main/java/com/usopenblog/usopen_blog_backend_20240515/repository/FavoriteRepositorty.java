package com.usopenblog.usopen_blog_backend_20240515.repository;

import com.usopenblog.usopen_blog_backend_20240515.entity.FavoriteEntiy;
import com.usopenblog.usopen_blog_backend_20240515.entity.primaeyKey.FavoritePk;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepositorty extends JpaRepository<FavoriteEntiy, FavoritePk> {


}
