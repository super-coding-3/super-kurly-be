package com.kurly.api.member.controller;

import com.kurly.api.config.security.CustomLogoutHandler;
import com.kurly.api.jpa.entity.RoleType;
import com.kurly.api.member.model.MemberSignUp;
import com.kurly.api.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * packageName    : com.kurly.api.member.controller
 * fileName       : MemberController
 * author         : hagjoon
 * date           : 2024-04-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-23        hagjoon       최초 생성
 */
@RestController
@RequestMapping("/api/member")
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    private final CustomLogoutHandler customLogoutHandler;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody MemberSignUp memberSignUp){
        boolean isSuccess = memberService.signUp(memberSignUp);

        if(isSuccess){
            return ResponseEntity.ok(Collections.singletonMap("message","회원가입이 완료되었습니다."));
        }else {
            return ResponseEntity.badRequest().body(Collections.singletonMap("message","회원가입에 실패했습니다."));
        }
    }


}
