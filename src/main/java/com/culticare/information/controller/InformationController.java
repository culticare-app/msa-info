package com.culticare.information.controller;

import com.culticare.information.controller.dto.response.EduListResponseDto;
import com.culticare.information.service.InformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/info")
@RequiredArgsConstructor
@RestController
public class InformationController {

    private final InformationService informationService;

    @GetMapping("/education/list")
    public ResponseEntity<EduListResponseDto> findEduList(@PageableDefault(size = 20, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {

        EduListResponseDto result = informationService.findEduList("EDU", pageable);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


}
