package com.example.oop.model;


//getter and setter methods for the variables used for each book (title, author, genre, price)
public class Book {
     private int id;
     private String title;
     private String author;
     private String genre;
     private int price;
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
 
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getGenre() {
        return genre;
    }
 
    public void setGenre(String genre) {
        this.genre = genre;
    }
 
    public int getPrice() {
        return price;
    }
 
    public void setPrice(int price) {
        this.price = price;
    }
 
}
