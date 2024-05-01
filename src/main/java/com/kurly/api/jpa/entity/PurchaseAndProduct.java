package com.kurly.api.jpa.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PurchaseAndProduct {
    private Long productId;
    private String name;
    private Integer price;
    private LocalDateTime purchaseDate;
}
