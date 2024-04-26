package com.kurly.api.memberMyPage.controller;

import com.kurly.api.memberMyPage.dto.MemberInfo;
import com.kurly.api.memberMyPage.service.MemberMyPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@Slf4j
@RequiredArgsConstructor
public class MemberMyPageController {

    private final MemberMyPageService memberMyPageService;

    @GetMapping("/my-info/{id}")
    public MemberInfo findMemberInfo(@PathVariable Long id) {
        MemberInfo memberInfo = memberMyPageService.findMemberInfoById(id);
        return memberInfo;
    }

}
