package com.kurly.api.jpa.repository;

import com.kurly.api.jpa.entity.BasketProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketProductRepository extends JpaRepository<BasketProduct, Integer> {
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
public interface BasketProductRepository extends JpaRepository<BasketProduct,Integer> {
}
