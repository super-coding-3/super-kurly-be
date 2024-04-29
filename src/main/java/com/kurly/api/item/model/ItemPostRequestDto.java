package com.kurly.api.item.model;

import com.kurly.api.jpa.entity.Item;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@ToString
public class ItemPostRequestDto {


    @NotBlank
    private final String name;

    @NotNull
    @Min(0)
    private final Integer amount;

    @NotBlank
    private final String color;

    @NotNull
    @Min(0)
    private final Integer price;

    @NotBlank
    @Size(max = 150)
    private final String description;
    // TODO decide how to handle img
    //  Method A: 2 API (1: Post product, 2: Post image)
    //  Method B: 1 API ...
    //  (Storage: (1) DB BLOB / (2) img into other storage + img url into DB)

    @Builder
    public ItemPostRequestDto(
            String name,
            Integer amount,
            String color,
            Integer price,
            String description
    ) {

        name = name.strip(); //strip() 유니코드상에서 공백으로 보이는 모든 것을 문자열 앞뒤에선 제외
        color = color.strip();
        description = description.strip();

        this.name = name;
        this.amount = amount;
        this.color = color;
        this.price = price;
        this.description = description;
    }

    public Item toEntity() {
        return Item.builder()
                .name(getName())
                .amount(getAmount())
                .color(getColor())
                .price(getPrice())
                .description(getDescription())
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
                .color(getColor())
                .price(getPrice())
                .description(getDescription())
                .createAt(convertedCreateAt)
                .build();
    }
}
