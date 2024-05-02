package com.kurly.api.basket.controller;

import com.kurly.api.basket.model.BasketProductModel;
import com.kurly.api.basket.model.MyCartModel;
import com.kurly.api.basket.service.BasketService;
import com.kurly.api.jpa.entity.Item;
import com.kurly.api.jpa.entity.Member;
import com.kurly.api.jpa.entity.Options;
import com.kurly.api.jpa.repository.ItemRepository;
import com.kurly.api.jpa.repository.MemberRepository;
import com.kurly.api.jpa.repository.OptionRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    private final OptionRepository optionRepository;

    @PutMapping("/product/{basketId}")
    public BasketProductModel updateBasket(@PathVariable Long basketId, @RequestBody BasketProductModel basketProductModel) {
        BasketProductModel updatedBasket = basketService.updateBasket(basketProductModel.getBasketId(), basketProductModel);
        return updatedBasket;
    }

   @PostMapping("/order")
   public String orderProduct(@RequestBody BasketProductModel basketProductModel) {return null;}

   @PostMapping("add/{item_id}/{amount}")
   @Operation(summary = "장바구니 담기")
   public void itemBasket(@PathVariable("item_id") Long itemId,
                          @PathVariable("amount") Integer amount,
                          @RequestParam(value = "option_id", required = false) Long optionId)
    {

        Item item=itemRepository.findItemByID(itemId);
        Options options=optionRepository.findByOptionId(optionId);

       basketService.createCart(item,amount,options);
   }

   @GetMapping("/mycart")
   @Operation(summary = "장바구니 보기")
    public ResponseEntity<List<MyCartModel>> showMyCart(){
       List<MyCartModel> myCartModels= basketService.showMyCart();
       return ResponseEntity.ok().body(myCartModels);
   }
}
