package com.pmaddula4.librarybackend.service;

import com.pmaddula4.librarybackend.model.Item;
import com.pmaddula4.librarybackend.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(String id) {
        return itemRepository.findById(id);
    }

    public List<Item> getItemsByTitle(String title) {
        return itemRepository.findByTitle(title);
    }

    public List<Item> getItemsByAuthor(String author) {
        return itemRepository.findByAuthor(author);
    }

    public List<Item> getItemsByType(String type) {
        return itemRepository.findByType(type);
    }

    public List<Item> getItemsByBorrowedBy(String borrowedBy) {
        return itemRepository.findByBorrowedBy(borrowedBy);
    }

    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    public void deleteItem(String id) {
        itemRepository.deleteById(id);
    }

}
