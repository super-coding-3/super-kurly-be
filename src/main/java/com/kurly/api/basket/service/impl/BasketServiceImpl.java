package com.kurly.api.basket.service.impl;

import com.fasterxml.jackson.databind.node.BaseJsonNode;
import com.kurly.api.basket.model.BasketProductModel;
import com.kurly.api.basket.service.BasketService;
import com.kurly.api.jpa.entity.BasketProduct;
import com.kurly.api.jpa.entity.Item;
import com.kurly.api.jpa.repository.BasketProductRepository;
import com.kurly.api.jpa.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import com.kurly.api.jpa.repository.OptionRepository;
import com.kurly.api.jpa.entity.Member;
import com.kurly.api.jpa.entity.Options;
import com.kurly.api.jpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    private final OptionRepository optionRepository;
    private final MemberRepository memberRepository;


    public BasketProductModel updateBasket(Integer basketId, BasketProductModel basketProductModel) {
        BasketProduct basketProduct = basketProductRepository.findById(basketId)
                                    .orElseThrow(() -> new NotFoundException(("해당 ID : " + basketId + "의 물품을 찾을 수 없습니다.")));

        basketProduct.setItem((List<Item>) basketProductModel);
        basketProductRepository.save(basketProduct);

        return basketProductModel;
    }

    @Override
    public void createCart(String id,String amount, String user) {
        if (user !=null){
            Integer userId=Integer.valueOf(user);
            Integer idInt=Integer.valueOf(id);
            Integer amountInt=Integer.valueOf(amount);
//            Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
//            List<Basket> baskets=basketRepository.findByMemberId(userId);

            Options options=optionRepository.findById(idInt).orElseThrow(
                    ()-> new IllegalArgumentException("요청하신 옵션은 없습니다."));


        }


    }


}
