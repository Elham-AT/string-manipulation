package com.revature.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    // This class OPENs connections and delivers them to our DAO

    private static final ConnectionFactory connectionFactory = new ConnectionFactory(); // eagerly instantiated singleton
    private Properties props = new Properties();

    private ConnectionFactory(){ // default no arg constructor is public, singletons don't want that
        try {
            props.load(new FileReader("src/main/resources/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

<<<<<<< HEAD
    static { // static block, just runs everything inside the {} (block) at class loading
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    // getter for our instance of a ConnectionFactory
    public static ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

    public Connection getConnection(){
        try {
            return DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
=======
    // we need one public method that returns the connection:
    public static Connection getConnection() {
        if(connection == null) {
            // Resource Bundle:
            ResourceBundle bundle = ResourceBundle.getBundle("DbConfig");
            // create the connection:
            String url = bundle.getString("url");
            String user = bundle.getString("username");
            String password = bundle.getString("password");
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch(SQLException exception) {
                exception.printStackTrace();
            }
>>>>>>> e838a1f8d35847d0dbc00e95eba8cc984428675b
        }
    }
}

