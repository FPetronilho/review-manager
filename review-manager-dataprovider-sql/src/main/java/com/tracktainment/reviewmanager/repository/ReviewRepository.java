package com.tracktainment.reviewmanager.repository;

import com.tracktainment.reviewmanager.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

    Optional<ReviewEntity> findById(String id);

    void deleteById(String id);
}
