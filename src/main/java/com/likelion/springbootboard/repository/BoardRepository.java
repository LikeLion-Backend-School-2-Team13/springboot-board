package com.likelion.springbootboard.repository;

import com.likelion.springbootboard.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
