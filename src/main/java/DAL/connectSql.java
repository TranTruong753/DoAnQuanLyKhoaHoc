/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class connectSql {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/school";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static Connection getConnection(){     
        try {
            Connection connection;
            // Tạo kết nối
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println("KET NOI THANH CONG");
            return connection;  
            // Lấy dữ liệu CourseID        
        } catch (SQLException e) {
            System.err.println("Lỗi khi kết nối đến MySQL: " + e.getMessage());
        }                      
        return null;
    }
    
    public static void closeConnection(Connection c) {
            try {
                if(c!=null) {
                        c.close();
                }
            } catch (Exception e) {
                    e.printStackTrace();
            }
	}
	
    public static void printInfo(Connection c) {
        try {
            if(c!=null) {
                    DatabaseMetaData mtdt = c.getMetaData();
                    System.out.println(mtdt.getDatabaseProductName());
                    System.out.println(mtdt.getDatabaseProductVersion());
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        getConnection();
    }
}
