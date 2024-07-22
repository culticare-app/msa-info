package com.culticare.repository;

import com.culticare.entity.News;
import com.culticare.entity.NewsType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NewsRepository extends JpaRepository<News, Long> {

    Optional<News> findByNewsType(NewsType newsType);

}
