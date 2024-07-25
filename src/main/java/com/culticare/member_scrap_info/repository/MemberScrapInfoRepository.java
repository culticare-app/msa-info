package com.culticare.member_scrap_info.repository;

import com.culticare.information.entity.Information;
import com.culticare.member_scrap_info.entity.MemberScrapInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Member;
import java.util.List;

public interface MemberScrapInfoRepository extends JpaRepository<MemberScrapInfo, Long> {


    boolean existsByMemberIdAndInformation(Long memberId, Information information);
    void deleteByMemberIdAndInformation(Long memberId, Information information);

    List<MemberScrapInfo> findByMemberId(Long memberId);
}
