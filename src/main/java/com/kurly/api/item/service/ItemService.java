package com.kurly.api.item.service;

import com.kurly.api.item.model.ItemAllPage;
import com.kurly.api.item.model.ItemModel;
import com.kurly.api.item.model.ItemRqModel;
import com.kurly.api.jpa.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

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

    Item save(Item item);

    Item createItem(ItemRqModel model, MultipartFile imgFile, MultipartFile descriptionImgFile, MultipartFile productInformationImgFile)throws IOException;

    String saveImage(Item item, MultipartFile image, Instant date);

    String saveDescriptionImage(Item item, MultipartFile image, Instant date);

    String saveProductInformationImage(Item item, MultipartFile image, Instant date);

    ItemModel getItemById(Long itemId);

    ItemModel ItemUpdate(Long id, Integer newAmount);

    Page<ItemAllPage> findAllWithPageable(Pageable pageable);
    ItemModel findItemDetail(String id);

    List<ItemAllPage> getRandomItems(int i);
}
