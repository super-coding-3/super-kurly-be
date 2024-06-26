package com.kurly.api.basket.service.impl;

import com.fasterxml.jackson.databind.node.BaseJsonNode;
import com.kurly.api.basket.model.BasketProductModel;
import com.kurly.api.basket.model.MyCartModel;
import com.kurly.api.basket.service.BasketService;
import com.kurly.api.jpa.entity.*;
import com.kurly.api.jpa.repository.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private final ItemRepository itemRepository;


    public BasketProductModel updateBasket(Long basketId, BasketProductModel basketProductModel) {
        BasketProduct basketProduct = basketProductRepository.findById(basketId)
                                    .orElseThrow(() -> new NotFoundException(("해당 ID : " + basketId + "의 물품을 찾을 수 없습니다.")));

//        basketProduct.setItem((List<Item>) basketProductModel);
        basketProductRepository.save(basketProduct);

        return basketProductModel;
    }

    @Override
    public void createCart(Item newItem, Integer amount, Options options) {

        //1.로그인 유무
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String currentEmail = authentication.getName();
        Long memberId=memberRepository.findByEmailToId(currentEmail);
        Member member1=memberRepository.findByMember(memberId);

        //2. 로그인 했으면 로그인한 아이디에 장바구니 있는지 확인 없으면 새로 만들고 있으면 이어서 만든다.
        if (memberId==null){
            throw new IllegalArgumentException("로그인 해주세요");
        }else{
            Basket basket =basketRepository.findByMemberId(memberId);

            if (basket ==null) {
                basket = Basket.CreateBasket(member1);
                basketRepository.save(basket);
            }
            Item item= itemRepository.findItemByID(newItem.getProductId());

            BasketProduct  basketProduct = BasketProduct.createBasketItem(basket,item,amount,options);

                if(options ==null) {
                    int newPrice = basketProduct.getTotalPrice() * amount;
                    basketProduct.setTotalPrice(newPrice);
                }else{
                    int newPrice = options.getPrice() * amount;
                    basketProduct.setTotalPrice(newPrice);
                    basketProduct.setOptionId(options);
//                }
            }

            // 장바구니 상품 저장
            basketProductRepository.save(basketProduct);

            // 총 수량 업데이트
            int totalAmount = (basket.getTotalAmount() != null) ? basket.getTotalAmount() : 0;
            basket.setTotalAmount(totalAmount + amount);

        }

    }

    @Override
    public List<MyCartModel> showMyCart() {

        //1.로그인 유무
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String currentEmail = authentication.getName();
        Optional<Member> memberOptional = memberRepository.findByEmail(currentEmail);

        if (memberOptional.isEmpty()){
            throw new IllegalArgumentException("로그인 해주세요");
        }else {
            Long memberId=memberRepository.findByEmailToId(currentEmail);
            List<BasketProduct> basketProducts = basketProductRepository.findByMemberId(memberId);

            List<MyCartModel> myCartModels =new ArrayList<>();
            Integer totalPrice=0;
            Integer totalAmount=0;
            for (BasketProduct basketProduct:basketProducts){
                MyCartModel myCartModel= new MyCartModel();
                myCartModel.setName(basketProduct.getItem().getName());
                myCartModel.setDescription(basketProduct.getItem().getDescription());
                if (basketProduct.getOptionId() != null) {
                    myCartModel.setTitle(basketProduct.getOptionId().getTitle());
                } else {
                    myCartModel.setTitle(null);
                }
                myCartModel.setPrice(basketProduct.getTotalPrice());
                myCartModel.setAmount(basketProduct.getTotalAmount());
                myCartModels.add(myCartModel);
                totalPrice +=basketProduct.getTotalPrice();
                totalAmount += basketProduct.getTotalAmount();
            }

            for (MyCartModel myCartModel :myCartModels){
                myCartModel.setTotalPriceAndAmount(totalPrice, totalAmount);
            }
            return myCartModels;

        }

    }



}
