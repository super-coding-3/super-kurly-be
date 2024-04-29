package com.kurly.api.jpa.repository;

import com.kurly.api.jpa.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * packageName    : com.kurly.api.jpa.repository
 * fileName       : BasketRepository
 * author         : hagjoon
 * date           : 2024-04-26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-26        hagjoon       최초 생성
 */
@Repository
public interface BasketRepository extends JpaRepository<Basket,Long> {

}
