package com.kurly.api.memberMyPage.service;

import com.kurly.api.jpa.entity.Member;
import com.kurly.api.memberMyPage.dto.MemberInfo;
import com.kurly.api.jpa.repository.MemberInfoJpaRepository;
import com.kurly.api.memberMyPage.service.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberMyPageService {

    private final MemberInfoJpaRepository memberInfoJpaRepository;

    public MemberInfo findMemberInfoById(Long id) {

        Member member = memberInfoJpaRepository.findById(id)
                                        .orElseThrow(() -> new NotFoundException("해당 ID를 찾을 수 없습니다."));

        MemberInfo memberInfo = MemberMapper.INSTANCE.memberToMemberInfo(member);
        return memberInfo;

    }
}
