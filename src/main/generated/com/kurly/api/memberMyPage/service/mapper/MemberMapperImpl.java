package com.kurly.api.memberMyPage.service.mapper;

import com.kurly.api.jpa.entity.Member;
import com.kurly.api.memberMyPage.dto.MemberInfo;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-29T21:59:22+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Azul Systems, Inc.)"
)
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberInfo memberToMemberInfo(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberInfo memberInfo = new MemberInfo();

        memberInfo.setEmail( member.getEmail() );
        memberInfo.setName( member.getName() );
        memberInfo.setPhone( member.getPhone() );
        memberInfo.setAddr( member.getAddr() );
        memberInfo.setGender( member.getGender() );

        return memberInfo;
    }
}
