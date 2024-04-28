package com.kurly.api.jpa.repository;

import com.kurly.api.item.model.ItemModel;
import com.kurly.api.jpa.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {


    @Query("SELECT i " +
            "FROM Item i " +
            "JOIN i.options o " +
            "WHERE i.name= :name AND i.productId= o.product.productId")
    ItemModel findItemJoinOption(String name);
}
