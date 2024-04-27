package com.kurly.api.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "basket_product")
public class BasketProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer basketId;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private List<Item> item;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "total_Amount")
    private Integer totalAmount;
}
