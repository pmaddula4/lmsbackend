package com.pmaddula4.librarybackend.model;

import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

@Document
public class Item implements Serializable {
    private String title;
    private String author;
    private String type;
    private int pages;
    private int time;
    private String borrowedBy;
    private String imageURL;
    private String summary;

    public Item() {}

    public Item(String title, String author, String type, int pages, int time, String imageURL, String summary) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.pages = pages;
        this.time = time;
        this.borrowedBy = null;
        this.imageURL = imageURL;
        this.summary = summary;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getType() { return type; }
    public int getPages() { return pages; }
    public int getTime() {return time;}
    public String getBorrowedBy() { return borrowedBy; }
    public String getImageURL() { return imageURL; }
    public String getSummary() {return summary; }

    public void setBorrowedBy(String borrowedBy) { this.borrowedBy = borrowedBy; }

    @Override
    public String toString() {
        return "Title: " + title + ", author: " + author + ", type: " + type + ", pages: " + pages + ", time: " + time;
    }
}

