package com.kurly.api.item.service;

import com.kurly.api.item.model.ItemAllPage;
import com.kurly.api.item.model.ItemModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

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

    Page<ItemAllPage> findAllWithPageable(Pageable pageable);

    ItemModel findItemDetail(String id);
}
