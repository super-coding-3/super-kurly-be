package com.kurly.api.item.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record ItemImagePostResponseDto(Long productId, String url, String descriptionImageUrl, String productInformationImageUrl){
}
