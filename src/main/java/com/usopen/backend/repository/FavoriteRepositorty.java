package com.usopen.backend.repository;

import com.usopen.backend.entity.FavoriteEntiy;
import com.usopen.backend.entity.primaeyKey.FavoritePk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepositorty extends JpaRepository<FavoriteEntiy, FavoritePk> {


}
