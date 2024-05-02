package com.kurly.api.item.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OptionModel {
    @Schema(description = "옵션 명")
    private String title;
    @Schema(description = "옵션 가격")
    private Integer price;


    public OptionModel toEntity(){
        return new OptionModel(title,price);
    }
}
