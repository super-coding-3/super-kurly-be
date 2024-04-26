package com.kurly.api.jpa.repository;

import com.kurly.api.jpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberInfoJpaRepository extends JpaRepository<Member, Long> {
}
