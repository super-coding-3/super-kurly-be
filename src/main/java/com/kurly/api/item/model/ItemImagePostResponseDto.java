package com.kurly.api.item.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kurly.api.jpa.entity.Item;
import lombok.Builder;

@Builder
public record ItemImagePostResponseDto(Item savedEntity){
}
