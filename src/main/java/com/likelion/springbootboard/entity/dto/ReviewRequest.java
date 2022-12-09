package com.likelion.springbootboard.entity.dto;

import com.likelion.springbootboard.entity.Board;
import com.likelion.springbootboard.entity.Review;
import lombok.Getter;


@Getter
public class ReviewRequest {
    private String content;
    private String author;

    public Review toEntity(Board board) {
        return Review.builder()
                .content(content)
                .author(author)
                .board(board)
                .build();

    }
}
