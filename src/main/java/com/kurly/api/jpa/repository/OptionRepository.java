package com.kurly.api.jpa.repository;

import com.kurly.api.item.model.OptionModel;
import com.kurly.api.jpa.entity.Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<Options ,Long> {


    @Query("SELECT o FROM Options o WHERE o.product.productId= :productId")
    List<Options> findByProductId(Integer productId);
}
