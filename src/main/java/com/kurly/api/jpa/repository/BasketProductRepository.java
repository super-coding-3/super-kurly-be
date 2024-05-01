package com.kurly.api.jpa.repository;

import com.kurly.api.jpa.entity.BasketProduct;
import com.kurly.api.jpa.entity.MyBasketAndMyProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("SELECT new com.kurly.api.jpa.entity.MyBasketAndMyProduct(i.productId, i.name, i.price, bp.totalAmountBasketProduct) " +
            "FROM BasketProduct bp " +
            "JOIN bp.basket b " +
            "JOIN bp.item i " +
            "JOIN b.member m " +
            "WHERE m.memberId = :id ")
    List<MyBasketAndMyProduct> findMyBasketAndMyProduct(@Param("id") Long id);

    @Query("SELECT bp FROM BasketProduct bp JOIN bp.item i WHERE bp.basket.basketId = :basketId AND i.productId = :productId  ")
    BasketProduct findByBaksetIdAndItemId(Long basketId, Long productId);

    @Query("SELECT bp FROM BasketProduct bp WHERE bp.basket.member.memberId= :memberId")
    List<BasketProduct> findByMemberId(Long memberId);
}
