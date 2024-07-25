package com.culticare.information.repository.custom;

import com.culticare.information.entity.Education;
import com.culticare.information.entity.Recruitment;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.culticare.information.entity.QEducation.education;
import static com.culticare.information.entity.QRecruitment.recruitment;

@Repository
@RequiredArgsConstructor
public class RecruitmentCustomRepositoryImpl implements RecruitmentCustomRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Recruitment> findAll(Pageable pageable) {
        List<Recruitment> results = queryFactory
                .select(recruitment)
                .from(recruitment)
                .orderBy(recruitment.id.desc())
                .limit(pageable.getPageSize()+1)
                .fetch();

        return results;
    }

}
