package com.kurly.api.memberMyPage.controller;

import com.kurly.api.memberMyPage.dto.MemberInfo;
import com.kurly.api.memberMyPage.dto.MyBaseketProduct;
import com.kurly.api.memberMyPage.dto.MyProduct;
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
    public List<MyProduct> findMyBasket(@PathVariable Long id) {
        List<MyProduct> myProducts = memberMyPageService.findBasketProduct(id);
        return myProducts;
    }

}
