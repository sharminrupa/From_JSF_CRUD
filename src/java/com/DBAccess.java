package com;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBAccess {
    private static Connection conn = null;
    public static Connection getconn() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        if (conn == null) {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/registation", "root", "");
        }
        return conn;    
    }
}
