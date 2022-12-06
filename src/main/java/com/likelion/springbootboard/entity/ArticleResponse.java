package com.likelion.springbootboard.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@AllArgsConstructor
@Getter
public class ArticleResponse {

    // 굳이 Article 이랑 ArticleResponse 이 받고자 하는 컬럼 까지 같은데 나눌 필요가 있을까?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 뭘 자동으로 해주는건지 모르겠다
    private Long id;
    private String title;
    private String content;

    public static ArticleResponse of(Article article) {
        return ArticleResponse.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .build();
    }

}
