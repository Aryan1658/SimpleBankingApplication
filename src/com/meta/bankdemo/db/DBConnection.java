package com.meta.bankdemo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection connection = null;

    public  DBConnection()  {
        if(connection == null){
           try{
               Class.forName("com.mysql.cj.jdbc.Driver");
               String username = "root";
               String password = "root";
               int port = 3306;
               String databaseName = "apple_bank";
               String url = "jdbc:mysql://localhost:" + port + "/" + databaseName;
               connection = DriverManager.getConnection(url,username,password);
               System.out.println("Database connected successfully.");
           }catch (Exception ex){
               ex.printStackTrace();
               System.out.println("Database connection failed.");
           }
        }
    }
}
