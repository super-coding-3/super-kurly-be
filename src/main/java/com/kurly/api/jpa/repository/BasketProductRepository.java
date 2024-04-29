package com.kurly.api.jpa.repository;

import com.kurly.api.jpa.entity.BasketProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketProductRepository extends JpaRepository<BasketProduct, Integer> {
}
