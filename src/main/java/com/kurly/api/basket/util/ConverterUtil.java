package com.kurly.api.basket.util;

import com.kurly.api.basket.model.MyCartModel;
import com.kurly.api.jpa.entity.BasketProduct;

import java.util.List;
import java.util.stream.Collectors;

public class ConverterUtil {
    public List<MyCartModel> convertToMyCartModels(List<BasketProduct> basketProducts){
        return basketProducts.stream()
                .map(this::convertToMyCartModel)
                .collect(Collectors.toList());
    }

    private MyCartModel convertToMyCartModel(BasketProduct basketProduct) {
        MyCartModel myCartModel =new MyCartModel();
        myCartModel.setName(basketProduct.getOptionId().getTitle());
        myCartModel.setDescription(basketProduct.getItem().getDescription());
        myCartModel.setAmount(basketProduct.getTotalPrice());
    //    myCartModel.setImg(basketProduct.getItem().getImg());
        myCartModel.setPrice(basketProduct.getTotalPrice());
        
        return myCartModel;
    }
}
