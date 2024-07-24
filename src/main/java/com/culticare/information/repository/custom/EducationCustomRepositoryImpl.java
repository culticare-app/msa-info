package com.culticare.information.repository.custom;

import com.culticare.information.entity.Education;
import com.culticare.information.entity.Information;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import java.util.List;

import static com.culticare.information.entity.QEducation.education;
import static com.culticare.information.entity.QInformation.information;

@Repository
@RequiredArgsConstructor
public class EducationCustomRepositoryImpl implements EducationCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Education> findAll(Pageable pageable) {

        List<Education> results = queryFactory
                .select(education)
                .from(education)
                .orderBy(education.id.desc())
                .limit(pageable.getPageSize()+1)
                .fetch();

        return results;
    }
}
