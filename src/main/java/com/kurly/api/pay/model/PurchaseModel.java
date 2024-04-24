package com.kurly.api.pay.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kurly.api.jpa.entity.Item;
import com.kurly.api.jpa.entity.Member;
import com.kurly.api.jpa.entity.Purchase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PurchaseModel {
    private Integer purchaseId;
    private List<Item> items;
    private Member member;
    private String purchaseDate;

    private static DateTimeFormatter formatter=
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public PurchaseModel(Purchase purchase) {
        this.purchaseId=purchase.getPurchaseId();
        this.items=purchase.getItem();
        this.member= purchase.getMember();
        this.purchaseDate=purchase.getPurchaseDate().format(formatter);
    }
}
