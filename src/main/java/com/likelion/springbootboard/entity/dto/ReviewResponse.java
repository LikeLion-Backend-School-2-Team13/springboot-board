package com.likelion.springbootboard.entity.dto;

import com.likelion.springbootboard.entity.Review;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewResponse {
    private Long id;
    private String author;
    private String content;

    public static ReviewResponse of(Review review) {
        return ReviewResponse.builder()
                .id(review.getId())
                .author(review.getAuthor())
                .content(review.getContent())
                .build();
    }
}
