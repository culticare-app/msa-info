package com.culticare.information.repository.custom;

import com.culticare.information.entity.Recruitment;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RecruitmentCustomRepository {

    public List<Recruitment> findAll(Pageable pageable);
}
