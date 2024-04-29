package com.kurly.api.memberMyPage.dto;

import com.kurly.api.jpa.entity.Member;
import com.kurly.api.jpa.entity.RoleType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberInfo {
    @Schema(description = "이메일")
    private String email;

    @Schema(description = "이름")
    private String name;

    @Schema(description = "핸드폰번호")
    private String phone;

    @Schema(description = "주소")
    private String addr;

    @Schema(description = "성별")
    private String gender;

    public MemberInfo(Member member) {
        this.email = member.getEmail();
        this.name = member.getName();
        this.phone = member.getPhone();
        this.addr = member.getAddr();
        this.gender = member.getGender();
    }
}
