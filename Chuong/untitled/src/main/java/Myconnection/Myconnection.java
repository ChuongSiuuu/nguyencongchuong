package Myconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Myconnection {
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "root";
    public static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/qlhs";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_CONNECTION_URL, DB_USER, DB_PASSWORD);
    }
}
