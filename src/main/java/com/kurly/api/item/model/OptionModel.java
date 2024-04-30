package com.kurly.api.item.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OptionModel {
    private String title;
    private Integer price;


    public OptionModel toEntity(){
        return new OptionModel(title,price);
    }
}
