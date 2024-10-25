package com.javaweb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static String url ="jdbc:mysql://localhost:3306/estatebasic";
    private static String user ="root";
    private static String pass ="123456";
    public static final Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(url,user,pass);
            return conn;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
