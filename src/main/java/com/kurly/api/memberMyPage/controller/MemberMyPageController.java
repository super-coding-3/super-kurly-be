package com.kurly.api.memberMyPage.controller;

import com.kurly.api.memberMyPage.dto.MemberInfo;

import com.kurly.api.memberMyPage.dto.MyBasketProduct;
import com.kurly.api.memberMyPage.dto.MyPurchase;
import com.kurly.api.memberMyPage.service.MemberMyPageService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/myPage")
@Slf4j
@RequiredArgsConstructor
public class MemberMyPageController {

    private final MemberMyPageService memberMyPageService;

    @GetMapping("/info/{id}")
    @Operation(summary = "member_id로 내 정보 조회")
    public ResponseEntity<?> findMyInfo(@PathVariable Long id) {
        try {
            MemberInfo memberInfo = memberMyPageService.findMemberInfoById(id);
            return new ResponseEntity<>(memberInfo, HttpStatus.OK);
        }
        catch (NotFoundException nfe) {
            return new ResponseEntity<>(nfe.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/basket/{id}")
    @Operation(summary = "member_id로 내 장바구니 목록 조회")
    public ResponseEntity<?> findMyBasket(@PathVariable Long id) {
        try {
            List<MyBasketProduct> myBasketProducts = memberMyPageService.findBasketProduct(id);
            return new ResponseEntity<>(myBasketProducts, HttpStatus.OK);
        }
        catch (NotFoundException nfe) {
            return new ResponseEntity<>(nfe.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/purchase/{id}")
    @Operation(summary = "member_id로 내 구매 목록 조회")
    public ResponseEntity<?> findMyPurchase(@PathVariable Long id) {
        try {
            List<MyPurchase> myPurchases = memberMyPageService.findPurchaseProduct(id);
            return new ResponseEntity<>(myPurchases, HttpStatus.OK);
        }
        catch (NotFoundException nfe) {
            return new ResponseEntity<>(nfe.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
