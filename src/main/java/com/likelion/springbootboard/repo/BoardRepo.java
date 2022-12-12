package com.likelion.springbootboard.repo;

import com.likelion.springbootboard.domain.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepo extends JpaRepository<Board,Long> {

    Page<Board> findByTitleContaining(String searchWord, Pageable pageable);
}
