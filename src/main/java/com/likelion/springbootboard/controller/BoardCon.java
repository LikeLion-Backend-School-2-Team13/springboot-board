package com.likelion.springbootboard.controller;


import com.likelion.springbootboard.domain.entity.Board;
import com.likelion.springbootboard.repo.BoardRepo;
import com.likelion.springbootboard.ser.BoardSer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/boards")
public class BoardCon {

    private final BoardSer boardSer;

    public BoardCon(BoardSer boardSer) {
        this.boardSer = boardSer;
    }

    //리스트페이지
    //v2 페이징처리
    @GetMapping("/list")
    public String boardList(Model model, @PageableDefault(page = 0,size = 5,sort = "id",direction= Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("list", boardSer.boardList(pageable));
        return "list";
    }

    //글 조회 상세페이지
    @GetMapping("/{id}") // api/v1/boards/1
    public String boardView(@PathVariable Long id, Model model) {
        model.addAttribute("view", boardSer.boardView(id));
        return "view";
    }

    //글작성 페이지
    @GetMapping("")
    public String write() {
        return "write";
    }
    @GetMapping("/write")
    public String write1() {
        return "write";
    }

    //개시글 등록 POST /api/v1/boards
    @PostMapping("")           // POST   /api/v1/boards
    public String showWrite(Board board, Model model) {
        ///v2 write에서 제목 내용 쓴거 db에 저장
        boardSer.boardWrite(board);
        //작성완료 메세지
        model.addAttribute("message","글 작성 완료");
        model.addAttribute("url","/api/v1/boards/list");
        return "message";
    }

    //삭제               delete    /api/v1/boards/1
    @DeleteMapping("/{id}")
    public String boardDel(@PathVariable Long id,Model model) {
        boardSer.deleteById(id);

        model.addAttribute("message","글 삭제 완료");
        model.addAttribute("url","/api/v1/boards/list");
        return "message";
    }

    //수정페이지
    @PutMapping("/{id}")
    public String boardPut(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardSer.boardView(id));
        return "put";
    }

    //수정 post
    @PostMapping("/update/{id}")
    public String boardsUpdate(@PathVariable Long id, Board board,Model model) {
        Board boardTem = boardSer.boardView(id);

        boardTem.setTitle(board.getTitle());
        boardTem.setContents(board.getContents());

        boardSer.boardWrite(boardTem);
        model.addAttribute("message","글 수정 완료");
        model.addAttribute("url","/api/v1/boards/list");
        return "message";
    }


}
