package com.likelion.springbootboard.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ArticleRequest {

    private Long id;
    private String title;
    private String content;

    // toArticle 은 무엇을 하는 건가
    // 사용자에게 요청받을 목록?
    public Article toArticle() {
        return new Article(id, title, content);
    }
}
