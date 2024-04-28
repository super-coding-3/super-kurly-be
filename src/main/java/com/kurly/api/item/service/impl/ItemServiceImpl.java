package com.kurly.api.item.service.impl;

import com.kurly.api.item.model.ItemModel;
import com.kurly.api.item.service.ItemService;
import com.kurly.api.jpa.entity.Item;
import com.kurly.api.jpa.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

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
@RequiredArgsConstructor
@Slf4j
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;


    public Page<ItemModel> findAllWithPageable( Pageable pageable) {
        Page<Item> items=itemRepository.findAll(pageable);
        List<ItemModel> itemModels= new ArrayList<>();

        for (Item item: items){
            if (item.getAmount()!=0){
                ItemModel itemModel =new ItemModel();
                itemModel.setProductId(item.getProductId());
                itemModel.setName(item.getName());
                itemModel.setAmount(item.getAmount());
                itemModel.setColor(item.getColor());
                itemModel.setPrice(item.getPrice());
                itemModel.setDescription(item.getDescription());
                itemModel.setCreateAt(item.getCreateAt().toString());
                itemModel.setImg(item.getImg());

                itemModels.add(itemModel);
            }
        }
        return new PageImpl<>(itemModels, pageable,items.getTotalElements());
    }
}
