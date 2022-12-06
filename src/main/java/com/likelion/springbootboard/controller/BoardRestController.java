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

    @PostMapping("")
    public Long create(@RequestBody BoardRequest boardRequest) {
        return boardService.add(boardRequest);
    }

    @GetMapping("/list")
    public List<Board> findAll() {
        return boardService.findAll();
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        boardService.deleteById(id);
        return ResponseEntity.ok().body("삭제가 완료 되었습니다");
    }

    @PatchMapping("/{id}/edit")
    public ResponseEntity<String> editBoard(@PathVariable("id") Long id, @RequestBody BoardRequest dto) {
        boardService.editBoard(id, dto);
        return ResponseEntity.ok().body("수정 완료.");

    }

}
