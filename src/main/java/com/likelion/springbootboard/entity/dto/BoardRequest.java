package com.likelion.springbootboard.entity.dto;


import com.likelion.springbootboard.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BoardRequest {

    private String title;
    private String content;
    private String author;

    public Board toBoard() {
        return Board.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
