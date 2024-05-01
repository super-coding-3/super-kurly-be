package com.kurly.api.memberMyPage.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kurly.api.jpa.entity.BasketProduct;
import com.kurly.api.jpa.entity.MyBasketAndMyProduct;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyBasketProduct {
    @Schema(description = "상품 id")
    private Long productId;

    @Schema(description = "상품 이름")
    private String name;

    @Schema(description = "상품 가격")
    private Integer price;

    @Schema(description = "상품 수량")
    private Integer amount;

    public MyBasketProduct(BasketProduct basketProduct) {
        this.productId = basketProduct.getItem().getProductId();
        this.name = basketProduct.getItem().getName();
        this.amount = basketProduct.getTotalAmount();
        this.price = basketProduct.getItem().getPrice();
    }

    public MyBasketProduct(MyBasketAndMyProduct myBasketAndMyProduct) {
        this.productId = myBasketAndMyProduct.getProductId();
        this.name = myBasketAndMyProduct.getName();
        this.amount = myBasketAndMyProduct.getAmount();
        this.price = myBasketAndMyProduct.getPrice();
    }
}
