package com.kurly.api.jpa.repository;

import com.kurly.api.jpa.entity.Item;
import com.kurly.api.jpa.entity.Member;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * packageName    : com.kurly.api.jpa.repository
 * fileName       : MemberRepository
 * author         : hagjoon
 * date           : 2024-04-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-23        hagjoon       최초 생성
 */
@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    Optional<Member> findByEmail(String email);

    boolean existsByEmail(String email);

    @Query("SELECT m FROM Member m WHERE m.memberId = :id")
    Member findByMember(Long id);
    @Query("SELECT m.memberId FROM Member m WHERE m.email = :currentEmail ")
    Long findByEmailToId(String currentEmail);
}
