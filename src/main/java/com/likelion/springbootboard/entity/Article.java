package com.likelion.springbootboard.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "board_space")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    private Long id;
    private String title;
    private String content;


}
