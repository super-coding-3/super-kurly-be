package com.kurly.api.item.model;

import com.kurly.api.jpa.entity.Item;
import com.kurly.api.jpa.entity.Options;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Getter
@ToString
public class ItemPostRequestDto {

    @Schema(description = "물품이름",example = "딸기")
    private final String name;

    @Schema(description = "수량" ,example = "10")
    private final Integer amount;

    @Schema(description = "가격" ,example = "10000")
    private final Integer price;

    @Schema(description = "상세설명" ,example = "새콤함")
    private final String description;

    @Schema(description = "옵션" ,example = "강원도딸기")
    private final List<Options> optionName;

    @Schema(description = "원산지" ,example = "국내산")
    private final String origin;

    @Schema(description = "배송방법" ,example = "퀵배송")
    private final String shippingMethod;

    @Schema(description = "판매자" ,example = "KIM")
    private final String sellerName;


    @Builder
    public ItemPostRequestDto(
            @NotBlank
            String name,
            @NotNull
            @Min(0)
            Integer amount,
            @NotNull
            @Min(0)
            Integer price,
            @NotBlank
            @Size(max = 150)
            String description,
            List<Options> optionName,
            @NotBlank
            String origin,
            @NotBlank
            String shippingMethod,
            @NotBlank
            String sellerName

    ) {
        name = name.strip(); //strip() 유니코드상에서 공백으로 보이는 모든 것을 문자열 앞뒤에선 제외
        description = description.strip();
        origin = origin.strip();
        shippingMethod = shippingMethod.strip();
        sellerName = sellerName.strip();

        this.name = name;
        this.amount = amount;
        this.price = price;
        this.description = description;
        this.optionName =optionName;
        this.origin = origin;
        this.shippingMethod = shippingMethod;
        this.sellerName = sellerName;

    }

    public Item toEntity() {
        return Item.builder()
                .name(getName())
                .amount(getAmount())
                .price(getPrice())
                .description(getDescription())
                .options(getOptionName())
                .origin(getOrigin())
                .shippingMethod(getShippingMethod())
                .sellerName(getSellerName())
                .createAt(LocalDateTime.now(ZoneId.of("Asia/Seoul")))
                .build();
    }

    public Item toEntity(Instant createAt) {
        LocalDateTime convertedCreateAt = LocalDateTime.ofInstant(
                createAt,
                ZoneId.of("Asia/Seoul")
        );

        return Item.builder()
                .name(getName())
                .amount(getAmount())
                .price(getPrice())
                .description(getDescription())
                .createAt(convertedCreateAt)
                //.options(getOptionName())
                .origin(getOrigin())
                .shippingMethod(getShippingMethod())
                .sellerName(getSellerName())
                .build();
    }
}
