package com.kurly.api.member.service.impl;

import com.kurly.api.config.jwt.JwtTokenProvider;
import com.kurly.api.jpa.entity.Member;
import com.kurly.api.jpa.entity.RoleType;
import com.kurly.api.jpa.repository.MemberRepository;
import com.kurly.api.member.model.MemberLogIn;
import com.kurly.api.member.model.MemberSignUp;
import com.kurly.api.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * packageName    : com.kurly.api.member.service.impl
 * fileName       : MemberServiceImpl
 * author         : hagjoon
 * date           : 2024-04-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-23        hagjoon       최초 생성
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public boolean signUp(MemberSignUp memberSignUp) {

        String email = memberSignUp.getEmail();
        String password = memberSignUp.getPassword();
        String phone = memberSignUp.getPhone();
        String name = memberSignUp.getUserName();
        String addr = memberSignUp.getAddress();
        String gender = memberSignUp.getGender();
        String brith = memberSignUp.getBrith();
        RoleType role = memberSignUp.getRole();

        String encodePassword = passwordEncoder.encode(password);

        Member member = memberRepository.findByEmail(email).orElseGet(()->
                memberRepository.save(Member.builder()
                                .email(email)
                                .password(encodePassword)
                                .name(name)
                                .phone(phone)
                                .addr(addr)
                                .gender(gender)
                                .birthDate(brith)
                                .role(role)
                        .build()));
        return true;
    }

    @Override
    public boolean signUpValidCheck(String email) {
        return memberRepository.existsByEmail(email);
    }

    @Override
    public String login(MemberLogIn login) {
        String email = login.getEmail();
        String password = login.getPassword();

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email,password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtTokenProvider.createToken(email);
    }
}
