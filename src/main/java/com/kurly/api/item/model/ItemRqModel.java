package com.kurly.api.item.model;

import com.kurly.api.jpa.entity.Item;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * packageName    : com.kurly.api.item.model
 * fileName       : ItemRqModel
 * author         : hagjoon
 * date           : 2024-05-02
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-02        hagjoon       최초 생성
 */
@Data
@Builder
public class ItemRqModel {

    @Schema(description = "상품명")
    private String name;

    @Schema(description = "수량" ,example = "10")
    private Integer amount;

    @Schema(description = "가격" ,example = "10000")
    private Integer price;

    @Schema(description = "상세설명" ,example = "새콤함")
    private String description;

    @Schema(description = "옵션" ,example = "강원도딸기")
    private String optionName;

    @Schema(description = "원산지" ,example = "국내산")
    private  String origin;

    @Schema(description = "배송방법" ,example = "퀵배송")
    private String shippingMethod;

    @Schema(description = "판매자" ,example = "KIM")
    private String sellerName;



    public Item toEntity(Instant createAt) {
        LocalDateTime convertedCreateAt = LocalDateTime.ofInstant(
                createAt,
                ZoneId.of("Asia/Seoul")
        );

        return Item.builder()
                .name(this.name)
                .amount(this.amount)
                .price(this.price)
                .description(this.description)
                .createAt(convertedCreateAt)
                .origin(this.origin)
                .shippingMethod(this.shippingMethod)
                .sellerName(this.sellerName)
                .build();
    }
}
