package com.likelion.springbootboard.dto.board;

import com.likelion.springbootboard.domain.board.Board;
import lombok.Getter;

@Getter
public class BoardResponse {
    private Long id;
    private String author;
    private String title;
    private String content;

    private BoardResponse() {
    }

    public BoardResponse(Long id, String author, String title, String content) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public static BoardResponse of(Board board) {
        return new BoardResponse(board.getId(), board.getAuthor(), board.getTitle(), board.getContent());
    }
}
