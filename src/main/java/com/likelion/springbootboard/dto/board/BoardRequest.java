package com.likelion.springbootboard.dto.board;

import com.likelion.springbootboard.domain.board.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class BoardRequest {
    private String author;
    private String title;
    private String content;

    private BoardRequest() {
    }

    public Board toEntity() {
        return Board.builder()
                .author(author)
                .title(title)
                .content(content)
                .build();
    }
}
