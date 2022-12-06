package com.likelion.springbootboard.application.board;

import com.likelion.springbootboard.domain.board.Board;
import com.likelion.springbootboard.domain.board.BoardRepository;
import com.likelion.springbootboard.dto.board.BoardRequest;
import com.likelion.springbootboard.dto.board.BoardResponse;
import com.likelion.springbootboard.exception.notfound.BoardNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Long saveBoard(BoardRequest boardRequest) {
        return boardRepository.save(boardRequest.toEntity()).getId();
    }

    public BoardResponse findById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(BoardNotFoundException::new);
        return BoardResponse.of(board);
    }

    @Transactional
    public BoardResponse editBoard(Long id, BoardRequest boardRequest) {
        Board board = boardRepository.findById(id).orElseThrow(BoardNotFoundException::new);
        board.update(boardRequest.toEntity());
        return BoardResponse.of(board);
    }

    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }
}
