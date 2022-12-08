package com.likelion.springbootboard.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Table(name = "board_space")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String author;

//    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
//    private List<Review> reviews;

    public void update(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
