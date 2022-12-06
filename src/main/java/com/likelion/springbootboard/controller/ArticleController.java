package com.likelion.springbootboard.controller;

import com.likelion.springbootboard.entity.Article;
import com.likelion.springbootboard.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
@Slf4j
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    @GetMapping("")
    public String helloPage() {
        return "main";
    }

    @GetMapping("/new")
    public String creatPage() {
        return "new";
    }

    @GetMapping("/boards")
    public String List(Model model) {
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "list";
    }
}
