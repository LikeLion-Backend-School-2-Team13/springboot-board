package com.likelion.springbootboard.controller;

import com.likelion.springbootboard.entity.Board;
import com.likelion.springbootboard.entity.dto.BoardRequest;
import com.likelion.springbootboard.entity.dto.BoardResponse;
import com.likelion.springbootboard.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/boards")
public class BoardRestController {
    private final BoardService boardService;

    public BoardRestController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/{id}")
    public BoardResponse findById(@PathVariable("id") Long id) {
        return boardService.getArticle(id);
    }

    // 추가는 된다. 하지만 아이디는 자동 생성 하고싶은데 아이디를 입력 해줘야만 글이 생성 된다.
    // 이걸 홈페이지로 적용을 어떻게 시킬까?
    @PostMapping("")
    public BoardResponse create(@RequestBody BoardRequest boardRequest) {
        return boardService.add(boardRequest);
    }

    @GetMapping("/list")
    public List<Board> findAll() {
        return boardService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        boardService.deleteById(id);
        return ResponseEntity.ok().body("삭제가 완료 되었습니다");
    }
}
