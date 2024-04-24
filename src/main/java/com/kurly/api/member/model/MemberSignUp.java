package com.kurly.api.member.model;

import com.kurly.api.jpa.entity.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName    : com.kurly.api.member.model
 * fileName       : MemberSignUp
 * author         : hagjoon
 * date           : 2024-04-24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-24        hagjoon       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberSignUp {

    private String email;

    private String password;

    private String name;

    private String phone;

    private String addr;

    private String gender;

    private RoleType role;
}
