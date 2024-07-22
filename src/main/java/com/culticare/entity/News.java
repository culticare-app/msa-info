package com.culticare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id")
    private Long id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "news_type_id")
    private NewsType newsType;

    @Builder
    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // 양방향 연관관계 편의 메서드
    public void setNewsType(NewsType newsType) {
        this.newsType = newsType;
        newsType.getNewsList().add(this);
    }
}
