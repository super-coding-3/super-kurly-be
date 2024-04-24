package com.kurly.api.member.controller;

import com.kurly.api.config.jwt.JwtProperties;
import com.kurly.api.config.security.CustomLogoutHandler;
import com.kurly.api.jpa.entity.RoleType;
import com.kurly.api.member.model.MemberLogIn;
import com.kurly.api.member.model.MemberSignUp;
import com.kurly.api.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
@Tag(name = "Member API Controller",description = "회원 API 정보 컨트롤러")
@RestController
@RequestMapping("/api/member")
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    private final CustomLogoutHandler customLogoutHandler;

    @PostMapping("/signup")
    @Operation(summary = "회원 가입")
    public ResponseEntity<?> signUp(@RequestBody MemberSignUp memberSignUp){
        boolean isSuccess = memberService.signUp(memberSignUp);

        if(isSuccess){
            return ResponseEntity.ok(Collections.singletonMap("message","회원가입이 완료되었습니다."));
        }else {
            return ResponseEntity.badRequest().body(Collections.singletonMap("message","회원가입에 실패했습니다."));
        }
    }

    @PostMapping("/login")
    @Operation(summary = "로그인")
    public ResponseEntity<?> logIn(@RequestBody MemberLogIn login, HttpServletResponse httpServletResponse){
        try{
            // 로그인 시도 및 jwt 토큰 생성
            String token = memberService.login(login);

            Map<String, String> responseBody = new HashMap<>();
            responseBody.put("message","로그인이 성공적으로 완료되었습니다.");

            httpServletResponse.setHeader(JwtProperties.HEADER_STRING,JwtProperties.TOKEN_PREFIX + token);
            log.info("jwt 토큰 : {} ",token);
            log.info("로그인 완료");
            return ResponseEntity.ok(responseBody);
        }catch (BadCredentialsException e){
            Map<String,String> errorBody = new HashMap<>();
            errorBody.put("error","이메일 또는 비밀번호가 올바르지 않습니다.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorBody);
        }catch (Exception e){
            Map<String, String> errorBody = new HashMap<>();
            errorBody.put("error","로그인 처리 중 문제가 발생하였습니다.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorBody);
        }
    }


}
