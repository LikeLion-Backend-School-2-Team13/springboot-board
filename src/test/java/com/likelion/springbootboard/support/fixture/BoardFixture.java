package com.likelion.springbootboard.support.fixture;

import com.likelion.springbootboard.domain.board.Board;
import com.likelion.springbootboard.dto.board.BoardRequest;
import com.likelion.springbootboard.dto.board.BoardResponse;

public enum BoardFixture {
    BOARD_1(1L, "제목1", "작성자1", "본문입니다1");

    private final Long id;
    private final String title;
    private final String author;
    private final String content;

    BoardFixture(Long id, String title, String author, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public BoardRequest request() {
        return new BoardRequest(author, title, content);
    }

    public BoardResponse response() {
        return new BoardResponse(id, author, title, content);
    }

    public Board entity() {
        return new Board(id, title, author, content);
    }
}
