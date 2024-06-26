package com.kurly.api.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "basket_product")
public class BasketProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_product_id")
    private Long basketProductId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Item item;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "basket_id")
    private  Basket basket;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "total_Amount")
    private Integer totalAmount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_id")
    private Options optionId;

    public static BasketProduct createBasketItem(Basket basket, Item item, Integer amount, Options options) {
        BasketProduct basketProduct=new BasketProduct();
        basketProduct.setBasket(basket);
        basketProduct.setItem(item);
        basketProduct.setTotalAmount(amount);
        if (options !=null){
            basketProduct.setTotalPrice(options.getPrice());
        }else {
            basketProduct.setTotalPrice(item.getPrice());
        }
        return basketProduct;
    }
}
