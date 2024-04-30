package com.kurly.api.item.controller;

import com.kurly.api.common.support.exception.CustomException;
import com.kurly.api.item.model.ItemModel;
import com.kurly.api.item.model.ItemPostRequestDto;
import com.kurly.api.jpa.entity.Item;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.Collections;
import com.kurly.api.item.model.ItemAllPage;
import com.kurly.api.item.service.ItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.SimpleTimeZone;

/**
 * packageName    : com.kurly.api.item.controller
 * fileName       : ItemController
 * author         : hagjoon
 * date           : 2024-04-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-23        hagjoon       최초 생성
 */
@RestController
@RequestMapping("/api/item")
@RequiredArgsConstructor
@Slf4j
public class ItemController {
    private final ItemService itemService;

    @PostMapping("/posts")
    @Operation(summary = "물품등록")
    public ResponseEntity<?> registerItem(@RequestBody @Valid ItemPostRequestDto dto) {
        log.info("POST/item 등록요청이 들어왔습니다.");
        Item entity = dto.toEntity(Instant.now());
        itemService.save(entity);
        return ResponseEntity.ok(Collections.singletonMap("message", "물품이 성공적으로 등록 되었습니다"));
    }


    @GetMapping("/{id}")
    @Operation(summary = "물품조회")
    public ResponseEntity<String> findByItem(@PathVariable Long id ) {
        try {
            log.info("GET/item 조회요청이 들어왔습니다.productId:" + id);
            ItemModel itemModel = itemService.getItemById(id);
            log.info("GET/item 조회응답:" + itemModel);
            return new ResponseEntity<>(String.valueOf(itemModel), HttpStatus.OK);
        } catch (CustomException ce) {
            log.error("Client 요청에 문제가 있어 다음 오류를 출력합니다.:" + ce.getMessage());
            return new ResponseEntity<>(ce.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/update{id}")
    @Operation(summary = "물품수량변경")
    public ResponseEntity<ItemModel> ItemAmountUpdate(@PathVariable Long id, @RequestBody Integer newAmount) {
        log.info("POST/item 수정요청이 들어왔습니다. productId :" + id);
        ItemModel updatedItem = itemService.ItemUpdate(id,newAmount);
        ResponseEntity<ItemModel> item = ResponseEntity.ok(updatedItem);
        log.info("GET/item 수정응답:" + item);
        return item;
    }

    @GetMapping("/page")
    public ResponseEntity<Page<ItemAllPage>> findAllItemPagination(@PageableDefault(size = 10)Pageable pageable){
        Page<ItemAllPage> page = itemService.findAllWithPageable(pageable);
        return ResponseEntity.ok().body(page);
    }


    @GetMapping("/page/{id}")
    public ItemModel findDetailItem(@PathVariable String id){
        return itemService.findItemDetail(id);
    }
}
