package com.kurly.api.memberMyPage.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyBasketAndMyProduct {
    private Integer productId;
    private String name;
    private Integer amount;
    private Integer price;
}
