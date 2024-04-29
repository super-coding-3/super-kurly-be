package com.kurly.api.member.model;

import com.kurly.api.jpa.entity.RoleType;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "이메일")
    private String email;

    @Schema(description = "비밀번호")
    private String password;

    @Schema(description = "이름")
    private String userName;

    @Schema(description = "핸드폰번호")
    private String phone;

    @Schema(description = "주소")
    private String address;

    @Schema(description = "성별")
    private String gender;

    @Schema(description = "권한")
    private RoleType role;
}
