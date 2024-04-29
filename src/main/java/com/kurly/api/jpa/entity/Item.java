package com.kurly.api.jpa.entity;

import com.kurly.api.item.model.ItemModel;
import com.kurly.api.item.model.ItemRp;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Item {
    @Id@Column(name = "product_id")@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "price")
    private Integer price;

    @Column(name = "description")
    private String description;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "img")
    private byte[] img;
  
    @Column(name = "description_img")
    private byte[] descriptionImg;

    @OneToMany(mappedBy = "product")
    private List<Options> options;

    @Column(name = "origin")
    private String origin;

    @Column(name = "shipping_method")
    private String shippingMethod;

    @Column(name = "seller_name")
    private String sellerName;

    @Column(name = "product_information_img")
    private byte[] productInformationImg;

    public static Item toDto(ItemModel itemModel){
        return Item.builder()
                .productId(itemModel.getProductId())
                .name(itemModel.getName())
                .amount(itemModel.getAmount())
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
                .price(itemRQ.getPrice())
                .description(itemRQ.getDescription())
                .createAt(itemRQ.getCreateAt())
                .build();
    }
}
