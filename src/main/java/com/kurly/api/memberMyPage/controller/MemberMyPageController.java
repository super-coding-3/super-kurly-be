package com.kurly.api.memberMyPage.controller;

import com.kurly.api.memberMyPage.dto.MemberInfo;

import com.kurly.api.memberMyPage.dto.MyBasketProduct;
import com.kurly.api.memberMyPage.dto.MyPurchase;
import com.kurly.api.memberMyPage.service.MemberMyPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/myPage")
@Slf4j
@RequiredArgsConstructor
public class MemberMyPageController {

    private final MemberMyPageService memberMyPageService;

    @GetMapping("/info/{id}")
    public MemberInfo findMyInfo(@PathVariable Long id) {
        MemberInfo memberInfo = memberMyPageService.findMemberInfoById(id);
        return memberInfo;
    }

    @GetMapping("/basket/{id}")
    public List<MyBasketProduct> findMyBasket(@PathVariable Long id) {
        List<MyBasketProduct> myBasketProducts = memberMyPageService.findBasketProduct(id);
        return myBasketProducts;
    }

    @GetMapping("/purchase/{id}")
    public List<MyPurchase> findMyPurchase(@PathVariable Long id) {
        List<MyPurchase> myPurchases = memberMyPageService.findPurchaseProduct(id);
        return myPurchases;
    }

}
