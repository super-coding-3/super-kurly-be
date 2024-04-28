package com.kurly.api.item.service.impl;

import com.kurly.api.jpa.entity.Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Options ,Integer> {
}
