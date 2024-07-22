package com.culticare.service;

import com.culticare.controller.dto.request.NewsCreateRequestDto;
import com.culticare.entity.News;
import com.culticare.entity.NewsType;
import com.culticare.repository.NewsRepository;
import com.culticare.repository.NewsTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class NewsService {

    private static NewsRepository newsRepository;
    private static NewsTypeRepository newsTypeRepository;

    @Transactional
    public void saveNews(NewsCreateRequestDto dto) {

        News news = dto.toEntity();

        NewsType newsType = newsTypeRepository.findByName(dto.getNewsType())
                .orElseGet(() -> {
                    NewsType newNewsType = NewsType.builder()
                            .name(dto.getTitle())
                            .build();
                    return newsTypeRepository.save(newNewsType);
                });

        news.setNewsType(newsType);

        newsRepository.save(news);
    }
}
