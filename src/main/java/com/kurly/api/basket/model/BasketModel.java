package com.kurly.api.basket.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.kurly.api.basket.model
 * fileName       : BasketModel
 * author         : hagjoon
 * date           : 2024-04-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-23        hagjoon       최초 생성
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BasketModel {
    @Schema(description = "장바구니 id")
    private Long basketId;
    @Schema(description = "맴버 id")
    private Long memberId;
    @Schema(description = "총 가격")
    private Integer totalPrice;
    @Schema(description = "총 수량")
    private Integer totalAmount;

}
