package com.likelion.springbootboard.repository;

import com.likelion.springbootboard.entity.Board;
import com.likelion.springbootboard.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
     List<Review> findByBoard(Board board);
}
