package com.kurly.api.member.controller;

import com.kurly.api.config.S3Uploader;
import com.kurly.api.config.jwt.JwtProperties;
import com.kurly.api.config.security.CustomLogoutHandler;
import com.kurly.api.jpa.entity.RoleType;
import com.kurly.api.member.model.MemberLogIn;
import com.kurly.api.member.model.MemberSignUp;
import com.kurly.api.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @GetMapping("/signUpValid")
    @Operation(summary = "회원 가입 이메일 중복체크")
    public ResponseEntity<?> sigUpValidCheck(@RequestParam(value = "email") String email){
        boolean isSuccess = memberService.signUpValidCheck(email);

        if(isSuccess){
            return ResponseEntity.ok(Collections.singletonMap("message","이미 존재하는 email 입니다."));
        }else{
            return ResponseEntity.ok(Collections.singletonMap("message","사용 가능한 email 입니다."));
        }
    }

    @PostMapping("/login")
    @Operation(summary = "로그인")
    public ResponseEntity<?> logIn(@RequestBody MemberLogIn login, HttpServletResponse httpServletResponse){
        try{
            // 로그인 시도 및 jwt 토큰 생성
            String token = memberService.login(login);

            Map<String,String> data = new HashMap<>();
            data.put("token",JwtProperties.TOKEN_PREFIX + token);

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("data",data);
            responseBody.put("message","로그인에 성공하였습니다. 토큰을 발급합니다.");

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

    @Operation(summary = "로그아웃")
    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response){
        customLogoutHandler.logout(request,response,null);
        log.info("로그아웃 완료");
    }


}
