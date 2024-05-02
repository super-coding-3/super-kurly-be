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
public class ItemAllPage {
//    @Schema(description = "제품 아이디")
//    private Long productId;
    @Schema(description = "제품 이름")
    private String name;
    @Schema(description = "제품 가격")
    private Integer price;
    @Schema(description = "제품 갯수")
    private Integer amount;
    @Schema(description = "제품 설명")
    private String description;
    @Schema(description = "제품 이미지")
    private String img;

}
