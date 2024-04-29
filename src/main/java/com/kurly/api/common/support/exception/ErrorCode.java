package com.kurly.api.common.support.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    ITEM_NOT_FOUND("해당 상품이 없습니다.", HttpStatus.NOT_FOUND),
    DUPLICATED_ITEM_NAME("이미 존재하는 상품 이름입니다." ,HttpStatus.CONFLICT),
    ITEM_NOT_ENOUGH_STOCK("재고가 부족합니다.", HttpStatus.BAD_REQUEST);

    private final String message;
    private final HttpStatus status;


    ErrorCode(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
}

