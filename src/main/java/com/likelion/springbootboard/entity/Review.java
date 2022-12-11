package com.likelion.springbootboard.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String author;

    @ManyToOne
//    @JoinColumn(name = "id") // error 가 뜬다
    @JoinColumn(name = "board_id")
    private Board board;

    public void update(Review review) {
        updateContent(review.getContent());
        updateAuthor(review.getAuthor());
    }

    private void updateContent(String content) {
        if (content != null) {
            this.content = content;
        }
    }
    private void updateAuthor(String author) {
        if (author != null) {
            this.author = author;
        }
    }
}
