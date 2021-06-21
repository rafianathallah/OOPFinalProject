package com.example.oop.database;

import java.sql.Connection;
import java.sql.DriverManager;


public class BookDatabase {
    

//used to establish connection to the mysql database
//static is used as it saves memory and this variable will be constant
//and used throughout the whole code
    
    static Connection con;
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost/oopfinalproject";
    static String uname = "root";
    static String pass = "";
   
    
    public static Connection getConnection() throws Exception{
        if(con == null){
            Class.forName(driver);
            con = DriverManager.getConnection(url,uname, pass);
        }
        return con;
    } 
 
}
