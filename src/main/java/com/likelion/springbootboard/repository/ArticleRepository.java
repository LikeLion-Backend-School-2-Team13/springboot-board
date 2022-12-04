package com.likelion.springbootboard.repository;

import com.likelion.springbootboard.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
