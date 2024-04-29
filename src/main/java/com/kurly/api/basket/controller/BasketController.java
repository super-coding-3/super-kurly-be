package com.kurly.api.basket.controller;

import com.kurly.api.basket.model.BasketProductModel;
import com.kurly.api.basket.service.impl.BasketServiceImpl;
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
@RequestMapping("/api/basket")
public class BasketController {

    private final BasketServiceImpl basketServiceImpl;

    public BasketController(BasketServiceImpl basketServiceImpl) {
        this.basketServiceImpl = basketServiceImpl;
    }

    @PutMapping("/basket/{id}")
    public BasketProductModel updateBasket(@PathVariable Integer id, @RequestBody BasketProductModel basketProductModel) {
        BasketProductModel updatedBasket = basketServiceImpl.updateBasket(basketProductModel.getBasketId(), basketProductModel);
        return updatedBasket;
    }
}
