package com.kurly.api.basket.controller;

import com.kurly.api.basket.model.BasketProductModel;
import com.kurly.api.basket.service.BasketService;
import com.kurly.api.jpa.entity.Item;
import com.kurly.api.jpa.entity.Member;
import com.kurly.api.jpa.repository.ItemRepository;
import com.kurly.api.jpa.repository.MemberRepository;
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
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @PutMapping("/product/{basketId}")
    public BasketProductModel updateBasket(@PathVariable Long basketId, @RequestBody BasketProductModel basketProductModel) {
        BasketProductModel updatedBasket = basketService.updateBasket(basketProductModel.getBasketId(), basketProductModel);
        return updatedBasket;
    }

   @PostMapping("/order")
   public String orderProduct(@RequestBody BasketProductModel basketProductModel) {return null;}

   @PostMapping("/{id}/{item_id}/{amount}")
   public void itemBasket(@PathVariable("id") Long id,
                          @PathVariable("item_id") Long itemId,
                          @PathVariable("amount") Integer amount){
        Member member = memberRepository.findByMember(id);
       Item item=itemRepository.findByOption(itemId);

       basketService.createCart(member,item,amount);
   }
}
