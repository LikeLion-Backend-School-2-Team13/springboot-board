package com.likelion.springbootboard.service;

import com.likelion.springbootboard.entity.Board;
import com.likelion.springbootboard.entity.dto.BoardRequest;
import com.likelion.springbootboard.entity.dto.BoardResponse;
import com.likelion.springbootboard.exception.BoardException;
import com.likelion.springbootboard.exception.ErrorCode;
import com.likelion.springbootboard.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // 아이디 이용해서 검색
    public BoardResponse getArticle(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(()-> new BoardException(ErrorCode.NOT_FOUND, "해당 id : "+id+" 가 존재하지 않습니다. "));
        return BoardResponse.of(board);
    }


    // 게시물 저장
    public Long add(BoardRequest boardRequest) {
        return boardRepository.save(boardRequest.toBoard()).getId();
    }

    // 게시물 리스트
    public List<Board> findAll() {
        List<Board> boards = boardRepository.findAll();
        return boards;
    }

    // 삭제
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public BoardResponse editBoard(Long id, BoardRequest dto) {
        Board board = boardRepository.findById(id).orElseThrow(()-> new BoardException(ErrorCode.NOT_FOUND, "해당 id : "+id+" 가 존재하지 않습니다. "));
        board.update(dto.getTitle(), dto.getContent(), dto.getAuthor());
        return BoardResponse.of(board);
    }

}
