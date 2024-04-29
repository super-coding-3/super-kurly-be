package com.kurly.api.item.controller;

import com.kurly.api.item.model.ItemAllPage;
import com.kurly.api.item.model.ItemModel;
import com.kurly.api.item.service.ItemService;
import com.kurly.api.item.service.impl.ItemServiceImpl;
import com.kurly.api.jpa.entity.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
public class ItemController {

    private final ItemService itemService;

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
