package com.kurly.api.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer purchaseId;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private List<Item> item;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;

}
