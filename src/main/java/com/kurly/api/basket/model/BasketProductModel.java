package com.kurly.api.basket.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kurly.api.jpa.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BasketProductModel {
    private Integer basketId;
    private String description;
    private byte[] img;
    private String name;
    private List<Item> items;
    private Integer totalPrice;
    private Integer totalAmount;
}
