package com.kurly.api.jpa.repository;

import com.kurly.api.jpa.entity.BasketProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * packageName    : com.kurly.api.jpa.repository
 * fileName       : BasketProductRepository
 * author         : hagjoon
 * date           : 2024-04-26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-26        hagjoon       최초 생성
 */
@Repository
public interface BasketProductRepository extends JpaRepository<BasketProduct,Long> {

    @Query("SELECT MyBasketAndMyProduct(i.productId, i.name, i.price, bp.totalAmount) " +
            "FROM BasketProduct bp " +
            "JOIN bp.basket b " +
            "JOIN bp.item i " +
            "JOIN b.member m " +
            "WHERE m.memberId = :id ")
    List<BasketProduct> findMyInfoAndMyProduct(Integer intId);
}
