package com.kurly.api.jpa.repository;

import com.kurly.api.jpa.entity.Purchase;
import com.kurly.api.jpa.entity.PurchaseAndProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName    : com.kurly.api.jpa.repository
 * fileName       : PurchaseRepository
 * author         : hagjoon
 * date           : 2024-04-26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-26        hagjoon       최초 생성
 */
@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
    @Query("SELECT new com.kurly.api.jpa.entity.PurchaseAndProduct(i.productId, i.name, i.price, p.purchaseDate) " +
            "FROM Purchase p " +
            "JOIN p.item i " +
            "WHERE p.member.memberId = :id ")
    List<PurchaseAndProduct> findMyPurchases(@Param("id") Long id);
}
