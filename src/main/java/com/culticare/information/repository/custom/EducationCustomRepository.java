package com.culticare.information.repository.custom;

import com.culticare.information.entity.Education;
import com.culticare.information.entity.Information;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface EducationCustomRepository {
    public List<Education> findAll(Pageable pageable);
    public List<Education> findScrappedEducation(Long loginMemberId, Pageable pageable);
}
