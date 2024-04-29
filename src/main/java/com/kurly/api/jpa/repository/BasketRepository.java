package com.kurly.api.jpa.repository;

import com.kurly.api.jpa.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Integer> {
}
