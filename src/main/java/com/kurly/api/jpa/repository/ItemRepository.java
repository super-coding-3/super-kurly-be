package com.kurly.api.jpa.repository;


import com.kurly.api.item.model.ItemRp;
import com.kurly.api.jpa.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {


    ItemRp findByName(String name);
    boolean existsByName(String name);
}
