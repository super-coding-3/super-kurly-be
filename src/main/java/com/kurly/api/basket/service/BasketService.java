package com.kurly.api.basket.service;

import com.kurly.api.basket.model.BasketProductModel;
import org.springframework.security.core.userdetails.User;

/**
 * packageName    : com.kurly.api.basket.service
 * fileName       : BasketService
 * author         : hagjoon
 * date           : 2024-04-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-23        hagjoon       최초 생성
 */
public interface BasketService {

    BasketProductModel updateBasket(Integer basketId, BasketProductModel basketProductModel);
    void createCart(String id,String amount, String user);
}
