package com.kurly.api.memberMyPage.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kurly.api.jpa.entity.BasketProduct;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberBasket {
    private List<BasketProduct> basketItems = new ArrayList<>();
    private Integer totalPrice;
    private Integer totalAmount;
}
