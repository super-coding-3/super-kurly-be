package com.kurly.api.memberMyPage.controller;

import com.kurly.api.memberMyPage.dto.MemberInfo;

import com.kurly.api.memberMyPage.dto.MyBasketProduct;
import com.kurly.api.memberMyPage.dto.MyPurchase;
import com.kurly.api.memberMyPage.service.MemberMyPageService;
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
