package org.example;

import java.sql.*;

public class Connect {
    private Connection conn;
    private Statement st;
    ResultSet rs;

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
            st.execute("CREATE TABLE IF NOT EXISTS TEST (ID INT PRIMARY KEY, TEXT VARCHAR(64));");
            st.execute("MERGE INTO TEST (ID, TEXT) VALUES (1, 'text text text');");
            rs = st.executeQuery("SELECT * FROM TEST;");

            rs.next();
            Integer id = rs.getInt("ID");
            String text = rs.getString("TEXT");
            System.out.println("ID = " + id + ", TEXT = " + text);

            conn.close();
            System.out.println("Status: Connection Closed!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
