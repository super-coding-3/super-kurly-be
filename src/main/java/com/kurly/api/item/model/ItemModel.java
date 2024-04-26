package com.kurly.api.item.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kurly.api.jpa.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * packageName    : com.kurly.api.item.model
 * fileName       : ItemModel
 * author         : hagjoon
 * date           : 2024-04-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-23        hagjoon       최초 생성
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemModel {
    private Integer productId;
    private String name;
    private Integer amount;
    private String color;
    private Integer price;
    private String description;
    private String createAt;
    private byte[] img;

    private static DateTimeFormatter formatter=
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public ItemModel(Item item){
        this.productId= item.getProductId();
        this.name= item.getName();
        this.amount=item.getAmount();
        this.color= item.getColor();
        this.price= item.getPrice();
        this.description= item.getDescription();
        this.createAt=item.getCreateAt().format(formatter);
        this.img= item.getImg();
    }

}
