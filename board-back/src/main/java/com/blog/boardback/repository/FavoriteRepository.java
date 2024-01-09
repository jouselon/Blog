package com.blog.boardback.repository;

import com.blog.boardback.entity.FavoriteEntity;
import com.blog.boardback.entity.primaryKey.FavoritePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<FavoriteEntity, FavoritePK> {
}
