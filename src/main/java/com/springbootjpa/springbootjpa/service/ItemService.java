package com.springbootjpa.springbootjpa.service;

import com.springbootjpa.springbootjpa.domain.Item;
import com.springbootjpa.springbootjpa.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;

    /**
     * 상품 등록
     *
     * @param item Item item
     */
    @Transactional
    public void save(Item item) {
        itemRepository.save(item);
    }

    /**
     * 전체 상품 조회
     *
     * @return List<Item> items
     */
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    /**
     * 상품 조회
     *
     * @param id Long id
     * @return Item item
     */
    public Item findOne(Long id) {
        return itemRepository.findOne(id);
    }
}
