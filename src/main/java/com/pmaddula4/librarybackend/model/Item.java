package com.pmaddula4.librarybackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

@Document(collection = "catalog")
public class Item implements Serializable {

    @Id
    private String id;

    private String title;
    private String author;
    private String type;
    private Integer pages;
    private Integer time;
    private String borrowedBy;
    private String imageURL;
    private String summary;

    public Item() {}

    public Item(String title, String author, String type, Integer pages, Integer time, String imageURL, String summary) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.pages = pages;
        this.time = time;
        this.borrowedBy = null;
        this.imageURL = imageURL;
        this.summary = summary;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getType() { return type; }
    public Integer getPages() { return pages; }
    public Integer getTime() {return time;}
    public String getBorrowedBy() { return borrowedBy; }
    public String getImageURL() { return imageURL; }
    public String getSummary() {return summary; }

    public void setBorrowedBy(String borrowedBy) { this.borrowedBy = borrowedBy; }

    @Override
    public String toString() {
        return "Title: " + title + ", author: " + author + ", type: " + type + ", pages: " + pages + ", time: " + time;
    }
}

