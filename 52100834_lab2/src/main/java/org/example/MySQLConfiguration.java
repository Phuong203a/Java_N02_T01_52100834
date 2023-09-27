package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConfiguration {

    public static Connection getConnection() {
         Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(Const.URL, Const.USER, Const.PASSWORD);
            System.out.println("Connection is Successful to the database" + Const.URL);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return connection;
    }

}
