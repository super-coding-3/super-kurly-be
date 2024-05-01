package com.kurly.api.memberMyPage.service;

import com.kurly.api.jpa.entity.Member;
import com.kurly.api.jpa.entity.MyBasketAndMyProduct;
import com.kurly.api.jpa.entity.PurchaseAndProduct;
import com.kurly.api.jpa.repository.BasketProductRepository;
import com.kurly.api.jpa.repository.MemberRepository;
import com.kurly.api.jpa.repository.PurchaseRepository;
import com.kurly.api.memberMyPage.dto.MemberInfo;
import com.kurly.api.memberMyPage.dto.MyBasketProduct;
import com.kurly.api.memberMyPage.dto.MyPurchase;
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
    private final PurchaseRepository purchaseRepository;

    public MemberInfo findMemberInfoById(Long id) {

        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("해당 ID를 찾을 수 없습니다."));

        MemberInfo memberInfo = MemberMapper.INSTANCE.memberToMemberInfo(member);
        return memberInfo;

    }


    public List<MyBasketProduct> findBasketProduct(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("해당 ID의 장바구니를 찾을 수 없습니다."));
        if (member != null) {
            List<MyBasketAndMyProduct> myBasketAndMyProducts = basketProductRepository.findMyBasketAndMyProduct(id);
            return myBasketAndMyProducts.stream().map(MyBasketProduct::new).collect(Collectors.toList());
        }
        else {
            return null;
        }
    }

    public List<MyPurchase> findPurchaseProduct(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("해당 ID의 구매 목록을 찾을 수 없습니다."));
        if (member != null) {
            List<PurchaseAndProduct> purchaseAndProducts = purchaseRepository.findMyPurchases(id);
            return purchaseAndProducts.stream().map(MyPurchase::new).collect(Collectors.toList());
        }
        else {
            return null;
        }
    }
}
