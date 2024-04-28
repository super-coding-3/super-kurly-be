package com.kurly.api.item.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kurly.api.jpa.entity.Item;
import com.kurly.api.jpa.entity.Options;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
    private Integer price;
    private String description;
    private String createAt;
    private List<OptionModel> options;
    private byte[] img;
    private byte[] descriptionImg;

    private static DateTimeFormatter formatter=
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

//    public ItemModel(Item item){
//        this.productId= item.getProductId();
//        this.name= item.getName();
//        this.amount=item.getAmount();
//        this.price= item.getPrice();
//        this.description= item.getDescription();
//        this.createAt=item.getCreateAt().format(formatter);
//        this.options=item.getOptions();
//        this.img= item.getImg();
//    }

}
