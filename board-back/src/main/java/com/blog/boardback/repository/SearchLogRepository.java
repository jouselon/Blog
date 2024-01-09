package com.blog.boardback.repository;

import com.blog.boardback.entity.SearchLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchLogRepository extends JpaRepository<SearchLogEntity, Integer> {
}
