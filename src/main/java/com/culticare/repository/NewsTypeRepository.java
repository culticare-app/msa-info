package com.culticare.repository;

import com.culticare.entity.NewsType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NewsTypeRepository extends JpaRepository<NewsType, Long> {

    Optional<NewsType> findByName(String name);
}
