package com.kurly.api.memberMyPage.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kurly.api.jpa.entity.BasketProduct;
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
}
