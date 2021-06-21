package com.example.oop.controller;

import com.example.oop.model.Book;
import java.util.List;

//interface of the database actions that will be implemented later
public interface BookActions {
    
    public void save(Book books);
    public void update(Book books);
    public void delete(Book books);
    public Book get(int id);
    public List<Book> list();
}
 
