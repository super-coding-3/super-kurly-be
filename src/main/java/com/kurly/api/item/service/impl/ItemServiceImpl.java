package com.kurly.api.item.service.impl;

import com.kurly.api.item.model.ItemAllPage;
import com.kurly.api.item.model.ItemModel;
import com.kurly.api.item.model.OptionModel;
import com.kurly.api.item.service.ItemService;
import com.kurly.api.jpa.entity.Item;
import com.kurly.api.jpa.entity.Options;
import com.kurly.api.jpa.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

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


    @Override
    public Page<ItemAllPage> findAllWithPageable(Pageable pageable) {
        Page<Item> items = itemRepository.findAll(pageable);
        Map<String, Integer> totalAmounts = new HashMap<>();
        Map<String, byte[]> firstImageMap = new HashMap<>();
        Map<String, String> descriptionMap = new HashMap<>();

        for (Item item : items) {
            if (item.getAmount() != 0) {
                String itemName = item.getName();
                int currentAmount = totalAmounts.getOrDefault(itemName, 0);
                totalAmounts.put(itemName, currentAmount + item.getAmount());

                // 이미지 맵에 해당 제품의 이미지가 없는 경우에만 추가
                firstImageMap.putIfAbsent(itemName, item.getImg());

                // 설명 맵에 해당 제품의 설명이 없는 경우에만 추가
                descriptionMap.putIfAbsent(itemName, item.getDescription());
            }
        }

        List<ItemAllPage> itemModels = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : totalAmounts.entrySet()) {
            String itemName = entry.getKey();
            int totalAmount = entry.getValue();
            byte[] image = firstImageMap.get(itemName);
            String description = descriptionMap.get(itemName);

            ItemAllPage itemModel = new ItemAllPage();
            itemModel.setName(itemName);
            itemModel.setAmount(totalAmount);
            itemModel.setImg(image);
            itemModel.setDescription(description);

            // 가격은 원래 가격을 그대로 사용
            Item item = items.stream().filter(i -> i.getName().equals(itemName)).findFirst().orElse(null);
            if (item != null) {
                itemModel.setPrice(item.getPrice());
            }

            itemModels.add(itemModel);
        }

        return new PageImpl<>(itemModels, pageable, itemModels.size());

    }

    @Override
    public ItemModel findById(String id) {
        return null;
    }


    @Override
    public List<ItemModel> findByIdWithNameJoinOption(String id) {
        Integer idInt =Integer.parseInt(id);
        Item item=itemRepository.findById(idInt)
                .orElseThrow(()->new IllegalArgumentException("해당 상품은 없습니다."));

        String name= item.getName();

        List<Item> items=itemRepository.findAll();

        List<ItemModel> itemModels = new ArrayList<>();

        for (Item item1:items){
            if (item1.getName().equals(name)){
                ItemModel itemModel= new ItemModel();
                itemModel.setProductId(item1.getProductId());
                itemModel.setName(item1.getName());
                itemModel.setPrice(item1.getPrice());
                itemModel.setDescription(item1.getDescription());
                itemModel.setDescriptionImg(item1.getDescriptionImg());
                itemModel.setAmount(item1.getAmount());
                itemModel.setCreateAt(item1.getCreateAt().toString());
                itemModel.setImg(item1.getImg());

                itemModels.add(itemModel);
            }

        }

        return itemModels;
    }

}
