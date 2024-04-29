package com.kurly.api.item.service;

import com.kurly.api.item.model.ItemRp;
import com.kurly.api.jpa.entity.Item;
import com.kurly.api.item.model.ItemModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * packageName    : com.kurly.api.item.service
 * fileName       : ItemService
 * author         : hagjoon
 * date           : 2024-04-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-23        hagjoon       최초 생성
 */
public interface ItemService {
    //ItemRp findAllItem(ItemRp rp);

    void save(Item item);
    void saveItem(ItemRp itemRp);

    ItemModel getItemById(Integer itemId);

    ItemModel ItemUpdate(Integer id, Integer newAmount);

    Page<ItemModel> findAllWithPageable(Pageable pageable);


}
