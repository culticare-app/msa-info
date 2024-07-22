package com.culticare.controller;

import com.culticare.controller.dto.request.NewsCreateRequestDto;
import com.culticare.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/news")
@RequiredArgsConstructor
@RestController
public class NewsController {

    private static NewsService newsService;

    // 문화탐구 뉴스 생성 - 관리자 페이지
    @PostMapping("/create")
    public ResponseEntity<Void> saveNews(NewsCreateRequestDto newsCreateRequestDto) {

        newsService.saveNews(newsCreateRequestDto);

        return ResponseEntity.ok().build();
    }
}
