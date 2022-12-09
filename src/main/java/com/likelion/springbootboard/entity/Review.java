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


    public void update(String content, String author) {
        this.content =content;
        this.author = author;
    }
}
