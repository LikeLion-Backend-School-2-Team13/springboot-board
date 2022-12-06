package com.likelion.springbootboard.presentation.board;

import com.likelion.springbootboard.application.board.BoardService;
import com.likelion.springbootboard.dto.board.BoardRequest;
import com.likelion.springbootboard.dto.board.BoardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("")
    public Long saveBoard(@RequestBody BoardRequest boardRequest) {
        return boardService.saveBoard(boardRequest);
    }

    @GetMapping("/{id}")
    public BoardResponse findById(@PathVariable Long id) {
        return boardService.findById(id);
    }

    @PatchMapping("/{id}")
    public BoardResponse editBoard(@PathVariable("id") Long id, @RequestBody BoardRequest boardRequest) {
        return boardService.editBoard(id, boardRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        boardService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
