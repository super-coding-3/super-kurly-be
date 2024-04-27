package com.kurly.api.pay.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kurly.api.jpa.entity.Item;
import com.kurly.api.jpa.entity.Member;
import com.kurly.api.jpa.entity.Sale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaleModel {
    private Integer saleId;
    private List<Item> items;
    private Member member;
    private String  saleDate;
    private Integer totalPrice;

    private static DateTimeFormatter formatter=
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public SaleModel(Sale sale) {
        this.saleId=sale.getSaleId();
        this.items=sale.getItem();
        this.member= sale.getMember();
        this.saleDate=sale.getSaleDate().format(formatter);
        this.totalPrice=sale.getTotalPrice();
    }
}
