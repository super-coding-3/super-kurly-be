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
    private Long basketId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Item item;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "basket_id")
    private  Basket basket;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "total_amountbasket_product")
    private Integer totalAmountBasketProduct;

    public static BasketProduct createBasketItem(Basket basket, Item item, Integer amount) {
        BasketProduct basketProduct=new BasketProduct();
        basketProduct.setBasket(basket);
        basketProduct.setItem(item);
        basketProduct.setTotalAmountBasketProduct(amount);
        basketProduct.setTotalPrice(item.getPrice()*amount);
        return basketProduct;
    }
}
