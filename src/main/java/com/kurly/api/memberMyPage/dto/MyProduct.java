package com.kurly.api.memberMyPage.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kurly.api.jpa.entity.BasketProduct;
import com.kurly.api.jpa.entity.MyBasketAndMyProduct;
import lombok.*;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyProduct {
    private Integer productId;
    private String name;
    private Integer amount;
    private Integer price;

    public MyProduct(BasketProduct basketProduct) {
        this.productId = basketProduct.getItem().getProductId();
        this.name = basketProduct.getItem().getName();
        this.amount = basketProduct.getTotalAmount();
        this.price = basketProduct.getItem().getPrice();
    }

    public MyProduct(MyBasketAndMyProduct myBasketAndMyProduct) {
        this.productId = myBasketAndMyProduct.getProductId();
        this.name = myBasketAndMyProduct.getName();
        this.amount = myBasketAndMyProduct.getAmount();
        this.price = myBasketAndMyProduct.getPrice();
    }
}
