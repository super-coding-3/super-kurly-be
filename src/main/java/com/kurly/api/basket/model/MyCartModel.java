package com.kurly.api.basket.model;

import com.kurly.api.jpa.entity.Item;
import com.kurly.api.jpa.entity.Options;
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
    private String description;
    private byte[] img;
    private String name;
    private String title;
    private List<Item> items;
    private Integer price;
    private Integer amount;
    private Integer totalPrice;
    private Integer totalAmount;
    private Options option;
    public void setTotalPriceAndAmount(Integer totalPrice, Integer totalAmount) {
        this.totalPrice = totalPrice;
        this.totalAmount = totalAmount;
    }

}
