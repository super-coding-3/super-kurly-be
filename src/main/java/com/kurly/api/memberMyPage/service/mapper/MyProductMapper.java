package com.kurly.api.memberMyPage.service.mapper;

import com.kurly.api.jpa.entity.BasketProduct;
import com.kurly.api.memberMyPage.dto.MyProduct;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MyProductMapper {
    MyProductMapper INSTANCE = Mappers.getMapper(MyProductMapper.class);

    MyProduct myProduct(BasketProduct basketProduct);
}
