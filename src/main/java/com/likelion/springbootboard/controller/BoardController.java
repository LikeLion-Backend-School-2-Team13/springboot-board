package com.likelion.springbootboard.controller;

import com.likelion.springbootboard.entity.Board;
import com.likelion.springbootboard.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
@Slf4j
public class BoardController {

    private final BoardRepository boardRepository;

    public BoardController(BoardRepository articleRepository) {
        this.boardRepository = articleRepository;
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
        List<Board> articles = boardRepository.findAll();
        model.addAttribute("articles", articles);
        return "list";
    }
}
