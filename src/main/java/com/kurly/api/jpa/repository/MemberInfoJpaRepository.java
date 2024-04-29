package com.kurly.api.jpa.repository;

import com.kurly.api.jpa.entity.BasketProduct;
import com.kurly.api.jpa.entity.Item;
import com.kurly.api.jpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberInfoJpaRepository extends JpaRepository<Member, Long> {
    List<Item> MyInfoAndMyProduct(Long id);
}
