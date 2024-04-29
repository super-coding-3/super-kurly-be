package com.kurly.api.memberMyPage.service;

import com.kurly.api.jpa.entity.BasketProduct;
import com.kurly.api.jpa.entity.Member;
import com.kurly.api.jpa.repository.BasketProductRepository;
import com.kurly.api.jpa.repository.MemberRepository;
import com.kurly.api.memberMyPage.dto.MemberInfo;
import com.kurly.api.memberMyPage.dto.MyProduct;
import com.kurly.api.memberMyPage.service.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberMyPageService {

    private final MemberRepository memberRepository;
    private final BasketProductRepository basketProductRepository;

    public MemberInfo findMemberInfoById(Long id) {

        Member member = memberRepository.findById(id)
                                        .orElseThrow(() -> new NotFoundException("해당 ID를 찾을 수 없습니다."));

        MemberInfo memberInfo = MemberMapper.INSTANCE.memberToMemberInfo(member);
        return memberInfo;

    }


    public List<MyProduct> findBasketProduct(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("해당 ID를 찾을 수 없습니다."));
        Long intId = (long) id.intValue();
        if (member != null) {
            List<BasketProduct> basketProducts = basketProductRepository.findMyInfoAndMyProduct(intId);
            return basketProducts.stream().map(MyProduct::new).collect(Collectors.toList());
        }
        else {
            return null;
        }
    }
}
