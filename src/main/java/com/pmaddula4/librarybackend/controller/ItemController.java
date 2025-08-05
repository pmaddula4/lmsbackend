package com.pmaddula4.librarybackend.controller;

import com.pmaddula4.librarybackend.model.Item;
import com.pmaddula4.librarybackend.repo.ItemRepository;
import com.pmaddula4.librarybackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/title/all")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/title/{title}")
    public List<Item> getByTitle(@PathVariable String title) {
        return itemService.getItemsByTitle(title);
    }

    @GetMapping("/author/{author}")
    public List<Item> getByAuthor(@PathVariable String author) {
        return itemService.getItemsByAuthor(author);
    }

    @GetMapping("/type/{type}")
    public List<Item> getItemsByType(@PathVariable String type) {
        return itemService.getItemsByType(type);
    }

    @GetMapping("/borrowedBy/{borrowedBy}")
    public List<Item> getByBorrowedBy(@PathVariable String borrowedBy) {
        return itemService.getItemsByBorrowedBy(borrowedBy);
    }
}
