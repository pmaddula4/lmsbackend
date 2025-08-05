package com.pmaddula4.librarybackend.repo;

import com.pmaddula4.librarybackend.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ItemRepository extends MongoRepository<Item, String> {

    List<Item> findByTitle(String title);
    List<Item> findByAuthor(String author);
    List<Item> findByType(String type);

    List<Item> findByBorrower(String borrower);
    List<Item> findByBorrowed(boolean borrowed);



}
