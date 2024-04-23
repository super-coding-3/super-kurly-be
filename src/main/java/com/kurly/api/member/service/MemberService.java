package com.kurly.api.member.service;

import com.kurly.api.jpa.entity.RoleType;
import com.kurly.api.member.model.MemberSignUp;

/**
 * packageName    : com.kurly.api.member.service
 * fileName       : MemberService
 * author         : hagjoon
 * date           : 2024-04-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-23        hagjoon       최초 생성
 */
public interface MemberService {
    boolean signUp(MemberSignUp memberSignUp);
}
