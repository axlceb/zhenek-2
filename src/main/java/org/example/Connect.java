package org.example;

import java.sql.*;

public class Connect {
    private Connection conn;
    private Statement st;

    public Connect() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:h2:~/test7", "sa", "");
            System.out.println("Status: Connected!");
            st = conn.createStatement();
            conn.close();
            System.out.println("Status: Connection Closed!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
