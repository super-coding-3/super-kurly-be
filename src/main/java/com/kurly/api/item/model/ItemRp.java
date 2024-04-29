package com.kurly.api.item.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ItemRp {
    @Schema(description = "이름" ,example = "TV")
    private String name;
    @Schema(description = "물품수량" ,example = "1")
    private Integer amount;
    @Schema(description = "색상" ,example = "red")
    private String color;
    @Schema(description = "가격" ,example = "1500000")
    private Integer price;
    @Schema(description = "물품설명" ,example = "화질좋음")
    private String description;
    @Schema(description = "물품등록시간")
    private LocalDateTime createAt;
}
