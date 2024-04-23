package com.kurly.api.member.service.impl;

import com.kurly.api.config.jwt.JwtTokenProvider;
import com.kurly.api.jpa.entity.Member;
import com.kurly.api.jpa.entity.RoleType;
import com.kurly.api.jpa.repository.MemberRepository;
import com.kurly.api.member.model.MemberSignUp;
import com.kurly.api.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public boolean signUp(MemberSignUp memberSignUp, RoleType roleType) {
        memberSignUp.setRole(RoleType.USER);

        String email = memberSignUp.getEmail();
        String password = memberSignUp.getPassword();
        String name = memberSignUp.getName();
        String phone = memberSignUp.getPhone();
        String addr = memberSignUp.getAddr();
        String gender = memberSignUp.getGender();
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
                                .role(role)
                        .build()));
        return true;
    }
}
