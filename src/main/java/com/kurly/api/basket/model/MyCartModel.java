package com.kurly.api.basket.model;

import com.kurly.api.jpa.entity.Item;
import com.kurly.api.jpa.entity.Options;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyCartModel {
    @Schema(description = "제품 설명")
    private String description;
    @Schema(description = "대표이미지")
    private String img;
    @Schema(description = "제품 이름")
    private String name;
    @Schema(description = "옵션 이름")
    private String title;
    @Schema(description = "제품")
    private List<Item> items;
    @Schema(description = "제품 가격")
    private Integer price;
    @Schema(description = "제품 갯수")
    private Integer amount;
    @Schema(description = "총 가격")
    private Integer totalPrice;
    @Schema(description = "총 갯수")
    private Integer totalAmount;
    private Options option;
    public void setTotalPriceAndAmount(Integer totalPrice, Integer totalAmount) {
        this.totalPrice = totalPrice;
        this.totalAmount = totalAmount;
    }

}
