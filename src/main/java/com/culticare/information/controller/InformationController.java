package com.culticare.information.controller;

import com.culticare.information.controller.dto.response.*;
import com.culticare.information.service.InformationService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // 교육 정보 개별 조회
    @GetMapping("/education/{informationId}")
    public ResponseEntity<EducationResponseDto> findEducation(@RequestHeader("memberId") Long loginMemberId,
                                                              @PathVariable(value = "informationId") Long informationId) {
        return ResponseEntity.status(HttpStatus.OK).body(informationService.findEducation(loginMemberId, informationId));
    }

    // 복지센터 정보 개별 조회
    @GetMapping("/welfare-center/{informationId}")
    public ResponseEntity<WelfareCenterResponseDto> findWelfareCenter(@RequestHeader("memberId") Long loginMemberId,
                                                                      @PathVariable(value = "informationId") Long informationId) {
        return ResponseEntity.status(HttpStatus.OK).body(informationService.findWelfareCenter(loginMemberId, informationId));
    }

    // 채용공고 개별 조회
    @GetMapping("/recruitment/{informationId}")
    public ResponseEntity<RecruitmentResponseDto> findRecruitment(@RequestHeader("memberId") Long loginMemberId,
                                                                  @PathVariable(value = "informationId") Long informationId) {
        return ResponseEntity.status(HttpStatus.OK).body(informationService.findRecruitment(loginMemberId, informationId));
    }

    // ======== 회원의 정보 스크랩 =======

    // 회원-정보 스크랩 관계 등록
    @PostMapping("/scrap/{informationId}")
    public ResponseEntity<Void> saveScrapInfo(@RequestHeader("memberId") Long loginMemberId,
                                                 @PathVariable(value = "informationId") Long informationId) {
        informationService.saveScrapInfo(loginMemberId, informationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 회원-정보 스크랩 관계 삭제
    @DeleteMapping("/scrap/{informationId}")
    public ResponseEntity<Void> deleteScrapInfo(@RequestHeader("memberId") Long loginMemberId,
                                                @PathVariable(value = "informationId") Long informationId) {
        informationService.deleteScrapInfo(loginMemberId, informationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
