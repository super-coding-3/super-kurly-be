package com.kurly.api.jpa.repository;


import com.kurly.api.jpa.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item ,Integer> {

}
import com.kurly.api.jpa.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {


}
