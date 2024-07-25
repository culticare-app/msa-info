package com.culticare.information.controller;

import com.culticare.information.controller.dto.response.RecruitmentListResponseDto;
import com.culticare.information.controller.dto.response.WelfareCenterListResponseDto;
import com.culticare.information.controller.dto.response.EduListResponseDto;
import com.culticare.information.service.InformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/info")
@RequiredArgsConstructor
@RestController
public class InformationController {

    private final InformationService informationService;

    // 교육 정보 리스트 조회
    @GetMapping("/education/list")
    public ResponseEntity<EduListResponseDto> findEduList(@PageableDefault(size = 20, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        EduListResponseDto result = informationService.findEduList("EDU", pageable);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 복지센터 정보 리스트 조회
    @GetMapping("/welfare-center/list")
    public ResponseEntity<WelfareCenterListResponseDto> findWelfareCenterList(@PageableDefault(size = 20, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        WelfareCenterListResponseDto result = informationService.findWelfareCenterList("WELFARE_CENTER", pageable);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 채용공고 리스트 조회
    @GetMapping("/recruitment/list")
    public ResponseEntity<RecruitmentListResponseDto> findRecruitmentList(@PageableDefault(size = 20, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        RecruitmentListResponseDto result = informationService.findRecruitmentList("RECRUITMENT", pageable);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // ======== 회원의 정보 스크랩 =======

//    // 회원-정보 스클랩 관계 등록
//    @PostMapping()


}
