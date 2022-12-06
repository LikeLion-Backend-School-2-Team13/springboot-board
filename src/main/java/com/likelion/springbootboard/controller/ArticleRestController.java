package com.likelion.springbootboard.controller;

import com.likelion.springbootboard.entity.Article;
import com.likelion.springbootboard.entity.ArticleRequest;
import com.likelion.springbootboard.entity.ArticleResponse;
import com.likelion.springbootboard.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/boards")
public class ArticleRestController {
    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ArticleResponse findById(@PathVariable("id") Long id) {
        return articleService.getArticle(id);
    }

    // 추가는 된다. 하지만 아이디는 자동 생성 하고싶은데 아이디를 입력 해줘야만 글이 생성 된다.
    // 이걸 홈페이지로 적용을 어떻게 시킬까?
    @PostMapping("")
    public ArticleResponse create(@RequestBody ArticleRequest articleRequest) {
        return articleService.add(articleRequest);
    }

    @GetMapping("/list")
    public List<Article> findAll() {
        return articleService.findAll();
    }

}
