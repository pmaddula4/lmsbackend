package com.pmaddula4.librarybackend.controller;

import com.pmaddula4.librarybackend.model.Item;
import com.pmaddula4.librarybackend.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/title/{title}")
    public List<Item> getByTitle(@PathVariable String title) {
        return itemRepository.findByTitle(title);
    }

    @GetMapping("/author/{author}")
    public List<Item> getByAuthor(@PathVariable String author) {
        return itemRepository.findByAuthor(author);
    }

    @GetMapping("/type/{type}")
    public List<Item> getItemsByType(@PathVariable String type) {
        return itemRepository.findByType(type);
    }

    @PutMapping("/borrow/{id}")
    public ResponseEntity<String> borrowItem(@PathVariable String id, @RequestParam String borrower) {
        Optional<Item> OItem = itemRepository.findById(id);
        if (OItem.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Item item = OItem.get();
        if (item.getBorrowedBy() != null) {
            return ResponseEntity.badRequest().body("Item is already borrowed");
        }

        item.setBorrowedBy(borrower);
        itemRepository.save(item);
        return ResponseEntity.ok("Item has been borrowed successfully");

    }

    @PutMapping("/return/{id}")
    public ResponseEntity<String> returnItem(@PathVariable String id, @RequestParam String username) {

        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Item item = optionalItem.get();
        if (item.getBorrowedBy() == null) {
            return ResponseEntity.badRequest().body("Item is not currently borrowed.");
        }

        if (!item.getBorrowedBy().equals(username)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You cannot return an item borrowed by someone else.");
        }

        item.setBorrowedBy(null);
        itemRepository.save(item);
        return ResponseEntity.ok("Item returned successfully.");
    }


    @GetMapping("/borrowedBy/{borrowedBy}")
    public List<Item> getByBorrowedBy(@PathVariable String borrowedBy) {
        return itemRepository.findByBorrowedBy(borrowedBy);
    }
}
