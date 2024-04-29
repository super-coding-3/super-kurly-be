package com.kurly.api.basket.controller;

import com.kurly.api.basket.model.BasketProductModel;
import com.kurly.api.basket.service.BasketService;
import com.kurly.api.jpa.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

/**
 * packageName    : com.kurly.api.basket.controller
 * fileName       : BasketController
 * author         : hagjoon
 * date           : 2024-04-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-23        hagjoon       최초 생성
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/basket")
public class BasketController {

    private final BasketService basketService;


    @PutMapping("/product/{basketId}")
    public BasketProductModel updateBasket(@PathVariable Integer basketId, @RequestBody BasketProductModel basketProductModel) {
        BasketProductModel updatedBasket = basketService.updateBasket(basketProductModel.getBasketId(), basketProductModel);
        return updatedBasket;
    }

   @PostMapping("/order")
   public String orderProduct(@RequestBody BasketProductModel basketProductModel) {return null;}

   @PostMapping("/{id}/{amount}")
   public void itemBasket(@PathVariable("id") String id,
                          @PathVariable("amount") String amount,
                          @AuthenticationPrincipal Member member){
       String username=member.getUsername();

       basketService.createCart(id,amount,username);
   }
}
