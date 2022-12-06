package com.likelion.springbootboard.service;

import com.likelion.springbootboard.entity.Board;
import com.likelion.springbootboard.entity.dto.BoardRequest;
import com.likelion.springbootboard.entity.dto.BoardResponse;
import com.likelion.springbootboard.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // 아이디 이용해서 검색
    public BoardResponse getArticle(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(()-> new RuntimeException());
        return BoardResponse.of(board);
    }


    // 게시물 저장
    public BoardResponse add(BoardRequest boardRequest) {
        Board board = boardRepository.save(boardRequest.toBoard());
        return BoardResponse.of(board);
    }

    // 게시물 리스트
    public List<Board> findAll() {
        List<Board> boards = boardRepository.findAll();
        return boards;
    }

    // 삭제
    public BoardResponse edit(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(()-> new RuntimeException());
        return BoardResponse.of(board);
    }
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

}
