package com.kurly.api.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "basket")
public class Basket {
    @Id@Column(name = "basket_id")@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer basketId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", unique = true ,nullable = false)
    private Member member;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "total_amount")
    private Integer totalAmount;

}
