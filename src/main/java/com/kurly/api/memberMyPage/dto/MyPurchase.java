package com.kurly.api.memberMyPage.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kurly.api.jpa.entity.PurchaseAndProduct;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyPurchase {

    @Schema(description = "상품 id")
    private Long productId;

    @Schema(description = "상품 이름")
    private String name;

    @Schema(description = "상품 가격")
    private Integer price;

    @Schema(description = "구매일자")
    private LocalDateTime purchaseDate;

    public MyPurchase(PurchaseAndProduct purchaseAndProduct) {
        this.productId = purchaseAndProduct.getProductId();
        this.name = purchaseAndProduct.getName();
        this.price = purchaseAndProduct.getPrice();
        this.purchaseDate = purchaseAndProduct.getPurchaseDate();
    }
}
