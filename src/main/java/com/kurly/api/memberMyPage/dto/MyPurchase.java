package com.kurly.api.memberMyPage.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kurly.api.jpa.entity.PurchaseAndProduct;
import lombok.*;

import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyPurchase {
    private Long productId;
    private String name;
    private Integer price;
    private LocalDateTime purchaseDate;

    public MyPurchase(PurchaseAndProduct purchaseAndProduct) {
        this.productId = purchaseAndProduct.getProductId();
        this.name = purchaseAndProduct.getName();
        this.price = purchaseAndProduct.getPrice();
        this.purchaseDate = purchaseAndProduct.getPurchaseDate();
    }
}
