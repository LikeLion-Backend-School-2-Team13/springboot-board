package com.likelion.springbootboard.service;

import com.likelion.springbootboard.entity.Article;
import com.likelion.springbootboard.entity.ArticleRequest;
import com.likelion.springbootboard.entity.ArticleResponse;
import com.likelion.springbootboard.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ArticleResponse getArticle(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(()-> new RuntimeException());
        return ArticleResponse.of(article);
    }


    // 만약에 ArticleResponse 가 아닌 Article 로 했으면 build 를 하나하나 해줘야 하나
    public ArticleResponse add(ArticleRequest articleRequest) {
        Article article = articleRepository.save(articleRequest.toArticle());
        return ArticleResponse.of(article);
    }

    public List<Article> findAll() {
        List<Article> articles = articleRepository.findAll();
        return articles;
    }

}
