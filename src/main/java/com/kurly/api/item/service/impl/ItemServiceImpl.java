package com.kurly.api.item.service.impl;

import com.kurly.api.item.model.ItemModel;
import com.kurly.api.item.model.ItemRp;
import com.kurly.api.item.service.ItemService;
import com.kurly.api.jpa.entity.Item;
import com.kurly.api.jpa.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;
import java.util.Optional;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : com.kurly.api.item.service.impl
 * fileName       : ItemServiceImpl
 * author         : hagjoon
 * date           : 2024-04-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-23        hagjoon       최초 생성
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    //private String uploadPath;

    public void saveItem(ItemRp itemRp) {
        Item item = Item.toDto2(itemRp);
        itemRepository.save(item);
    }

    //조회
    public ItemModel getItemById(Integer itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new NotFoundException("물품을 찾을 수 없습니다"));
        return ItemModel.toEntity(item);
    }

    public ItemModel ItemUpdate(Integer id, Integer newAmount) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            Item item = optionalItem.get();
            item.setAmount(newAmount);
            itemRepository.save(item);
            return ItemModel.toEntity(item);
        } else {
            throw new NotFoundException("해당 아이템을 찾수 없습니다:" + id);
        }
    }
    public Page<ItemModel> findAllWithPageable( Pageable pageable) {
        Page<Item> items=itemRepository.findAll(pageable);
        List<ItemModel> itemModels= new ArrayList<>();

        for (Item item: items){
            if (item.getAmount()!=0){
                ItemModel itemModel =new ItemModel();
                itemModel.setProductId(item.getProductId());
                itemModel.setName(item.getName());
                itemModel.setAmount(item.getAmount());
                itemModel.setPrice(item.getPrice());
                itemModel.setDescription(item.getDescription());
                itemModel.setCreateAt(LocalDateTime.parse(item.getCreateAt().toString()));
                itemModel.setImg(item.getImg());

                itemModels.add(itemModel);
            }
        }
        return new PageImpl<>(itemModels, pageable,items.getTotalElements());
    }


}
