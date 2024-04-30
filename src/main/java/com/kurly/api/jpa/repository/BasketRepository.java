package com.kurly.api.jpa.repository;

import com.kurly.api.jpa.entity.Basket;
import com.kurly.api.jpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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

    Optional<Basket> findByMember(Optional<Member> member);

    @Query("SELECT b FROM Basket b WHERE b.member.memberId = :memberId")
    Basket findByMemberId(Long memberId);
}
