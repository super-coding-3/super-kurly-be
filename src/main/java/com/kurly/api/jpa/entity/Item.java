package com.kurly.api.jpa.entity;

import com.kurly.api.item.model.ItemModel;
import com.kurly.api.item.model.ItemRp;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Item {
    @Id@Column(name = "product_id")@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "color", length = 10)
    private String color;

    @Column(name = "price")
    private Integer price;

    @Column(name = "description")
    private String description;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "img" )
    private byte[] img;

    public static Item toDto(ItemModel itemModel){
        return Item.builder()
                .productId(itemModel.getProductId())
                .name(itemModel.getName())
                .amount(itemModel.getAmount())
                .color(itemModel.getColor())
                .price(itemModel.getPrice())
                .description(itemModel.getDescription())
                .createAt(itemModel.getCreateAt())
                .img(itemModel.getImg())
                .build();
    }
    public static Item toDto2(ItemRp itemRQ){
        return  Item.builder()
                .name(itemRQ.getName())
                .amount(itemRQ.getAmount())
                .color(itemRQ.getColor())
                .price(itemRQ.getPrice())
                .description(itemRQ.getDescription())
                .createAt(itemRQ.getCreateAt())
                .build();
    }

    public static Item toUpdateEntity(ItemModel itemModel) {
        return Item.builder()
                .productId(itemModel.getProductId())
                .name(itemModel.getName())
                .amount(itemModel.getAmount())
                .color(itemModel.getColor())
                .price(itemModel.getPrice())
                .description(itemModel.getDescription())
                .createAt(itemModel.getCreateAt())
                .img(itemModel.getImg())
                .build();
    }
}
