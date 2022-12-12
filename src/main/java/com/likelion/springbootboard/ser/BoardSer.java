package com.likelion.springbootboard.ser;

import com.likelion.springbootboard.domain.entity.Board;
import com.likelion.springbootboard.repo.BoardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardSer {

    private final BoardRepo boardRepo;

    @Autowired
    public BoardSer(BoardRepo boardRepo) {
        this.boardRepo = boardRepo;
    }


    //form에서 전송눌렀을때 dv에 저장
    public void boardWrite(Board board) {
        boardRepo.save(board);
    }

    //db목록가져와서 게시글 보이기
    public Page<Board> boardList(Pageable pageable) {
        return boardRepo.findAll(pageable);
    }

    //특정 id글 불러오기
    public Board boardView(Long id) {
        return boardRepo.findById(id).get();
    }

    //특정 id 삭제
    public void deleteById(Long id) {
        boardRepo.deleteById(id);
    }

    //리스트 검색기능
    public Page<Board> searchList(String keyword,Pageable pageable){
        return boardRepo.findByTitleContaining(keyword,pageable);
    }
}
