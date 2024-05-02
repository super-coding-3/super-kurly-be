package com.kurly.api.jpa.entity;

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
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String img;
  
    @Column(name = "description_img")
    private String descriptionImg;

    @OneToMany(mappedBy = "product")
    private List<Options> options;

    @Column(name = "origin")
    private String origin;

    @Column(name = "shipping_method")
    private String shippingMethod;

    @Column(name = "seller_name")
    private String sellerName;

    @Column(name = "product_information_img")
    private String  productInformationImg;
}
