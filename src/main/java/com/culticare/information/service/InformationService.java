package com.culticare.information.service;

import com.culticare.information.controller.dto.response.EduListResponseDto;
import com.culticare.information.entity.Education;
import com.culticare.information.repository.EducationRepository;
import com.culticare.information.repository.InformationRepository;
import com.culticare.information.repository.RecruitmentRepository;
import com.culticare.information.repository.WelfareCenterRepository;
import com.culticare.information.repository.custom.EducationCustomRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class InformationService {

    private final InformationRepository informationRepository;
    private final EducationCustomRepositoryImpl educationCustomRepositoryImpl;
    private final EducationRepository educationRepository;
    private final RecruitmentRepository recruitmentRepository;
    private final WelfareCenterRepository welfareCenterRepository;


    public EduListResponseDto findEduList(String typeName, Pageable pageable) {

        List<Education> results = educationCustomRepositoryImpl.findAll(pageable);
        List<EduListResponseDto.EducationDto> eduDtoList = transferToEduListDto(results);

        boolean hasNext = false;

        // 조회한 결과 개수가 요청한 페이지 사이즈보다 클 경우, next =true
        if (eduDtoList.size() > pageable.getPageSize()) {
            hasNext = true;
            eduDtoList.remove(pageable.getPageSize());
        }

        return EduListResponseDto.builder()
                .nextPage(hasNext)
                .educations(eduDtoList)
                .build();
    }

    private List<EduListResponseDto.EducationDto> transferToEduListDto(List<Education> educationList) {

        List<EduListResponseDto.EducationDto> eduDtoList = new ArrayList<>();

        for (Education edu : educationList) {

            EduListResponseDto.EducationDto educationDto = EduListResponseDto.EducationDto.from(edu);
            eduDtoList.add(educationDto);
        }

        return eduDtoList;
    }
}
