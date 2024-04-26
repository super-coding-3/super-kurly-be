package com.kurly.api.item.controller;

import com.kurly.api.item.model.ItemModel;
import com.kurly.api.item.model.ItemRp;
import com.kurly.api.item.service.impl.ItemServiceImpl;
import com.kurly.api.jpa.entity.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;

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
    private final ItemServiceImpl itemService;
    @PostMapping("/posts")
    public ResponseEntity<?> registerItem(@RequestBody ItemRp itemRp ){
        itemRp.setCreateAt(LocalDateTime.now());
        itemService.saveItem(itemRp );
        return ResponseEntity.ok(Collections.singletonMap("message", "물품이 성공적으로 등록 되었습니다"));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findByItem(@PathVariable Integer id ){
        ItemModel itemModel = itemService.getItemById(id);
        return ResponseEntity.ok(itemModel);
    }
    @PostMapping("/update{id}")
    public ResponseEntity<?> ItemAmountUpdate(@PathVariable Integer id, @RequestBody Integer newAmount){
        ItemModel updatedItem = itemService.ItemUpdate(id,newAmount);
        return ResponseEntity.ok(updatedItem);


    }
}
