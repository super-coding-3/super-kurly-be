package com.kurly.api.jpa.repository;


import com.kurly.api.jpa.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item ,Integer> {

}

