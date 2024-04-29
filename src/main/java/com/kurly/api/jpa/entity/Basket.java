package com.kurly.api.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "basket")
public class Basket {
    @Id@Column(name = "basket_id")@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basketId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id", unique = true ,nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member; //구매자

    @OneToMany(mappedBy = "basket")
    private List<BasketProduct> basketItems;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "total_amount")
    private Integer totalAmount;



//    public static Basket createBasket(Member member){
//        Basket basket=new Basket();
//
//    }

}
