package com.likelion.springbootboard.controller;


import com.likelion.springbootboard.domain.entity.Board;
import com.likelion.springbootboard.repo.BoardRepo;
import com.likelion.springbootboard.ser.BoardSer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/boards")
public class BoardCon {

    private final BoardSer boardSer;
    private final BoardRepo boardRepo;

    public BoardCon(BoardSer boardSer, BoardRepo boardRepo) {
        this.boardSer = boardSer;
        this.boardRepo = boardRepo;
    }

    //리스트페이지
    @GetMapping("/list")
    public String boardList(Model model){
        model.addAttribute("list", boardSer.boardList());
        return "list";
    }

    //글 조회 상세페이지
    // v1 get방식
//    @GetMapping("/view") //view?id=1
//    public String boardView(Model model,Long id){
//        model.addAttribute("view",boardSer.boardView(id));
//        return "view";
//    }
    //v2 pathvariable                   GET /api/v1/boards/{id}
        @GetMapping("/{id}") // api/v1/boards/1
    public String boardView(@PathVariable Long id,Model model){
        model.addAttribute("view",boardSer.boardView(id));
        return "view";
    }

    //글작성 페이지
    @GetMapping("")
    public String write(){
        return "write";
    }
    @GetMapping("/write")
    public String write1(){
        return "write";
    }

    //개시글 등록 POST /api/v1/boards
    @PostMapping("")               // POST   /api/v1/boards
    public String showWrite(/*String title, String contents*/Board board){

        //v1(write연동전)
        //board.getTitle 안됨 ==> entity가서 @getter
        //제목은 : null ==> @setter
        //        System.out.println("제목은 : "+board.getTitle());
        //        System.out.println("내용은은 : "+board.getContents());
        //        System.out.println("작성완료");


        ///v2 write에서 제목 내용 쓴거 db에 저장
        boardSer.boardWrite(board);
        return "redirect:/api/v1/boards/list";
    }
            //삭제
    @DeleteMapping("/{id}") //           delete    /api/v1/boards/1
    public String boardDel(@PathVariable Long id){
        boardRepo.deleteById(id);
        return "redirect:/api/v1/boards/list";
    }


            //수정페이지
    @PutMapping("/{id}")
    public String boardPut(@PathVariable Long id, Model model){

        model.addAttribute("board",boardSer.boardView(id));

        return "put";
    }

    //수정 post
    @PostMapping("/update/{id}")
    public String boardsUpdate(@PathVariable Long id,Board board){
        Board boardTem=boardSer.boardView(id);

        boardTem.setTitle(board.getTitle());
        boardTem.setContents(board.getContents());

        boardSer.boardWrite(boardTem);

        return "redirect:/api/v1/boards/list";

    }

}
