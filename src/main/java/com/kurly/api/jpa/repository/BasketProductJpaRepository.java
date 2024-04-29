package com.kurly.api.jpa.repository;

import com.kurly.api.jpa.entity.BasketProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketProductJpaRepository extends JpaRepository<BasketProduct, Integer> {
    @Query("SELECT new com.kurly.api.jpa.entity.MyBasketAndMyProduct(i.productId, i.name, i.price, bp.totalAmount) " +
            "FROM BasketProduct bp " +
            "JOIN bp.basket b " +
            "JOIN bp.item i " +
            "JOIN b.member m " +
            "WHERE m.memberId = :id ")
    List<BasketProduct> findMyInfoAndMyProduct(Integer intId);

}
