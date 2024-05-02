package com.kurly.api.item.service.impl;

import com.kurly.api.common.support.exception.CustomException;
import com.kurly.api.common.support.exception.ErrorCode;
import com.kurly.api.config.S3Uploader;
import com.kurly.api.item.model.*;
import com.kurly.api.item.service.ItemService;
import com.kurly.api.jpa.entity.Item;
import com.kurly.api.jpa.entity.Options;
import com.kurly.api.jpa.repository.ItemRepository;
import com.kurly.api.jpa.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.MessageFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
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
    private final OptionRepository optionRepository;

    private final S3Uploader s3Uploader;

    @Override
    public String saveImage(Long productId, MultipartFile image) {
        try {
//            Instant now = Instant.now();
//            int year = now.get(ChronoField.YEAR);
//            int month = now.get(ChronoField.MONTH_OF_YEAR);
//            int date = now.get(ChronoField.DAY_OF_MONTH);
//            UUID uuid = UUID.randomUUID();
//            String directory = MessageFormat.format("{0}/{1}/{2}/{3}" ,year, month ,date, uuid);
            String directory  =LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            String fileUrl = s3Uploader.upload(image,directory);

            Item item = itemRepository.findById(productId)
                    .orElseThrow(()-> new CustomException(ErrorCode.ITEM_NOT_FOUND));
            item.setImg(fileUrl);
            item.setDescriptionImg(fileUrl);
            item.setProductInformationImg(fileUrl);
            itemRepository.save(item);

            return fileUrl;


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Item save(Item item) {
        boolean exists = itemRepository.existsByName(item.getName());

        if (exists && item.getProductId() == null) {
            throw new CustomException(ErrorCode.DUPLICATED_ITEM_NAME);
        }

        return itemRepository.save(item);
    }

    @Override
    public String saveImage(Item item, MultipartFile image, Instant date) {
        String fileUrl = uploadImage(item.getProductId(), image, date);
        item.setImg(fileUrl);
        return fileUrl;
    }

    @Override
    public String saveDescriptionImage(Item item, MultipartFile image, Instant date) {
        String fileUrl = uploadImage(item.getProductId(), image, date);
        item.setDescriptionImg(fileUrl);
        return fileUrl;
    }

    @Override
    public String saveProductInformationImage(Item item, MultipartFile image, Instant date) {
        String fileUrl = uploadImage(item.getProductId(), image, date);
        item.setProductInformationImg(fileUrl);
        return fileUrl;
    }

    //조회
    @Override
    public ItemModel getItemById(Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new CustomException(ErrorCode.ITEM_NOT_FOUND));
        return ItemModel.toEntity(item);

    }

    public ItemModel ItemUpdate(Long id, Integer newAmount) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            Item item = optionalItem.get();
            item.setAmount(newAmount);
            itemRepository.save(item);
            return ItemModel.toEntity(item);
        } else {
            throw new CustomException(ErrorCode.ITEM_NOT_FOUND);
        }
    }
        @Override
        public Page<ItemAllPage> findAllWithPageable (Pageable pageable){
            Page<Item> items = itemRepository.findAll(pageable);
            Map<String, Integer> totalAmounts = new HashMap<>();
            Map<String, String> firstImageMap = new HashMap<>();
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
                String image = firstImageMap.get(itemName);
                String description = descriptionMap.get(itemName);

                ItemAllPage itemModel = new ItemAllPage();
                itemModel.setName(itemName);
                itemModel.setAmount(totalAmount);
                //itemModel.setImg(image);
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
        public ItemModel findItemDetail (String id){

            Integer productId = Integer.parseInt(id);
            Item item = itemRepository.findById(Long.valueOf(productId)).orElseThrow(
                    () -> new IllegalArgumentException("해당 제품은 없습니다."));

            ItemModel itemModel = new ItemModel();
            itemModel.setName(item.getName());
            itemModel.setDescription(item.getDescription());
            itemModel.setPrice(item.getPrice());
            itemModel.setImg(item.getImg());
            itemModel.setDescriptionImg(item.getDescriptionImg());
            itemModel.setAmount(item.getAmount());
            itemModel.setOrigin(item.getOrigin());
            itemModel.setShippingMethod(item.getShippingMethod());
            itemModel.setSellerName(item.getSellerName());
            itemModel.setProductInformationImg(item.getProductInformationImg());

            List<Options> options= optionRepository.findByProductId(productId);
            List<OptionModel> optionModels =new ArrayList<>();
            for (Options option :options){
                    OptionModel optionModel = new OptionModel();
                    optionModel.setPrice(option.getPrice());
                    optionModel.setTitle(option.getTitle());
                    optionModels.add(optionModel);
            }

            itemModel.setOptionName(optionModels);
            return itemModel;
        }

    private String uploadImage(Long productId, MultipartFile image, Instant date) {
        try {
            String directory = createDirectory(date, productId);
            return s3Uploader.upload(image, directory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String createDirectory(Instant date, Long productId) {
        String formattedDate = DateTimeFormatter.ofPattern("yyyyMMdd")
                .withZone(ZoneOffset.UTC)
                .format(date);

        return MessageFormat.format(
                "product/{0}/{1}",
                formattedDate,
                productId
        );
    }
    }