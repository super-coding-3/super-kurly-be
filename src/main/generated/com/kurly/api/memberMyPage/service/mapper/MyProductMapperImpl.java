package com.kurly.api.memberMyPage.service.mapper;

import com.kurly.api.jpa.entity.BasketProduct;
import com.kurly.api.memberMyPage.dto.MyProduct;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-29T21:59:22+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Azul Systems, Inc.)"
)
public class MyProductMapperImpl implements MyProductMapper {

    @Override
    public MyProduct myProduct(BasketProduct basketProduct) {
        if ( basketProduct == null ) {
            return null;
        }

        MyProduct myProduct = new MyProduct();

        return myProduct;
    }
}
