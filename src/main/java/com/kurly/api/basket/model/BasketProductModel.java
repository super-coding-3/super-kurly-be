package com.kurly.api.basket.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kurly.api.jpa.entity.Item;
import com.kurly.api.jpa.entity.Options;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BasketProductModel {
    @Schema(description = "장바구니 id")
    private Long basketId;
    @Schema(description = "제품 설명")
    private String description;
    @Schema(description = "제품 이미지")
    private String img;
    @Schema(description = "제품 이름")
    private String name;
    @Schema(description = "제품")
    private List<Item> items;
    @Schema(description = "총 가격")
    private Integer totalPrice;
    @Schema(description = "총 수량")
    private Integer totalAmount;
    @Schema(description = "옵션")
    private Options option;
}
