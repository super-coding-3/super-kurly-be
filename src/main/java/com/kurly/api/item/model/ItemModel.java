package com.kurly.api.item.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kurly.api.jpa.entity.Item;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
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
@ToString
@Builder
public class ItemModel {
    @Schema(description = "물품아이디" ,example = "1")
    private Long productId;
    @Schema(description = "이름" ,example = "Tv")
    private String name;
    @Schema(description = "수량" ,example = "10")
    private Integer amount;
    @Schema(description = "가격" , example = "15000000")
    private Integer price;
    @Schema(description = "제품설명" ,example = "화질좋음")
    private String description;
    @Schema(description = "물품등록시간")
    private LocalDateTime createAt;

    private List<Options> optionName;
    @Schema(description = "제품이미지")
    private String img;
    private String  descriptionImg;
    private String origin;
    private String shippingMethod;
    private String sellerName;
    private String  productInformationImg;

    private static DateTimeFormatter formatter=
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public ItemModel(Item item) {
        this.productId = item.getProductId();
        this.name = item.getName();
        this.amount = item.getAmount();
        this.price = item.getPrice();
        this.description = item.getDescription();
        this.createAt = getCreateAt();
        //this.createAt=item.getCreateAt().format(formatter);
        this.img = item.getImg();
    }

    public static ItemModel toEntity(Item item){
        return ItemModel.builder()
                .productId(item.getProductId())
                .name(item.getName())
                .amount(item.getAmount())
                .price(item.getPrice())
                .description(item.getDescription())
                .createAt(item.getCreateAt())
                .img(item.getImg())
               // .optionName(item.getOptions())
                .descriptionImg(item.getDescriptionImg())
                .origin(item.getOrigin())
                .shippingMethod(item.getShippingMethod())
                .sellerName(item.getSellerName())
                .build();
    }

}
