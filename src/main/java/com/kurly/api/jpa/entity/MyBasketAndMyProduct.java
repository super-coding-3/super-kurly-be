package com.kurly.api.jpa.entity;

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
