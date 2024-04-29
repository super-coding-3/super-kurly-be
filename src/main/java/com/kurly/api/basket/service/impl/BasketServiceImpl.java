package com.kurly.api.basket.service.impl;

import com.fasterxml.jackson.databind.node.BaseJsonNode;
import com.kurly.api.basket.model.BasketProductModel;
import com.kurly.api.basket.service.BasketService;
import com.kurly.api.jpa.entity.BasketProduct;
import com.kurly.api.jpa.entity.Item;
import com.kurly.api.jpa.repository.BasketProductRepository;
import com.kurly.api.jpa.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

/**
 * packageName    : com.kurly.api.basket.service.impl
 * fileName       : BasketServiceImpl
 * author         : hagjoon
 * date           : 2024-04-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-23        hagjoon       최초 생성
 */
@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;
    private final BasketProductRepository basketProductRepository;


    public BasketProductModel updateBasket(Integer basketId, BasketProductModel basketProductModel) {
        BasketProduct basketProduct = basketProductRepository.findById(basketId)
                                    .orElseThrow(() -> new NotFoundException(("해당 ID : " + basketId + "의 물품을 찾을 수 없습니다.")));

        basketProduct.setItem((List<Item>) basketProductModel);
        basketProductRepository.save(basketProduct);

        return basketProductModel;
    }
}
