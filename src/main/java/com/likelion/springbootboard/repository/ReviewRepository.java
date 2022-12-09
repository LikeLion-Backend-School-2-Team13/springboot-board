package com.likelion.springbootboard.repository;

import com.likelion.springbootboard.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
