package com.example.demo.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {
    private String url;
    private String user;
    private String password;
    private Connection conn;

    public DatabaseConnectionManager() {
    }

    public Connection getConnection(){
        Properties prop = new Properties();
        try{
            FileInputStream propFile = new FileInputStream("src/main/resources/application.properties");
            prop.load(propFile);
            url = prop.getProperty("db.url");
            user = prop.getProperty("db.user");
            password = prop.getProperty("db.password");
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            conn = DriverManager.getConnection(url, user, password);

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            e.getErrorCode();
        }
        return conn;
    }
}
