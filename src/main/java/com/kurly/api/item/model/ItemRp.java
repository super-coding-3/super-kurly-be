package com.kurly.api.item.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemRp {
    private String name;
    private Integer amount;
    private String color;
    private Integer price;
    private String description;
    private LocalDateTime createAt;
}
