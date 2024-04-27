package com.kurly.api.member.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.kurly.api.member.model
 * fileName       : MemberLogIn
 * author         : hagjoon
 * date           : 2024-04-24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-24        hagjoon       최초 생성
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberLogIn {

    @Schema(description = "이메일")
    private String email;

    @Schema(description = "비밀번호")
    private String password;
}
