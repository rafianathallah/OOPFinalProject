package com.example.oop.controller;

import com.example.oop.model.Book;
import com.example.oop.database.BookDatabase;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


//implementing interface methods
public class BookImplement implements BookActions{

    @Override
    public void save(Book books) {
        
        try {
            //calls the connection to the database and takes the inputted title,author,genre,price into the prepared statement
            //and inserts it into the mysql table
            Connection con =  BookDatabase.getConnection();
            String sql = "INSERT INTO bookdatabase(title,author,genre,price) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, books.getTitle());
            ps.setString(2, books.getAuthor());
            ps.setString(3, books.getGenre());
            ps.setInt(4, books.getPrice());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saved!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error"); //returns error if not all things are filled
        }
    }
 
    @Override
    public void update(Book books) {  
        
         try {
            //same thing as save feature, this time it will update an existing database entry using prepared statements 
            Connection con = BookDatabase.getConnection();
            String sql = "UPDATE bookdatabase SET title=?,author=?,genre=?,price=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, books.getTitle());
            ps.setString(2, books.getAuthor());
            ps.setString(3, books.getGenre());
            ps.setInt(4, books.getPrice());
            ps.setInt(5, books.getId());
            ps.executeUpdate();
  
            JOptionPane.showMessageDialog(null, "Updated");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        
    }
 
    @Override
    public void delete(Book books) {
       //takes the ID of a selected entry and deletes it from the mysql table
       try {
            Connection con = BookDatabase.getConnection();
            String sql = "delete from bookdatabase  WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);  
            ps.setInt(1, books.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
 
    @Override
    public Book get(int id) {
        
        //takes inputted ID to prepared statement and returns the corresponding book information
         Book book = new Book();
        try {
            Connection con = BookDatabase.getConnection();
            String sql = "SELECT * FROM bookdatabase WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setGenre(rs.getString("genre"));
                book.setPrice(rs.getInt("price"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return book;
    }
    
    //creating arraylist that stores all the entries of books 
    @Override
    public List<Book> list() {
          
          List<Book> list = new ArrayList<Book>();
        try {
            Connection con = BookDatabase.getConnection();
            String sql = "SELECT * FROM bookdatabase ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setGenre(rs.getString("genre"));
                book.setPrice(rs.getInt("price"));
 
                list.add(book);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
  
    }
}
