package com.kurly.api.memberMyPage.service.mapper;

import com.kurly.api.jpa.entity.Member;
import com.kurly.api.memberMyPage.dto.MemberInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    MemberInfo memberToMemberInfo(Member member);

}
