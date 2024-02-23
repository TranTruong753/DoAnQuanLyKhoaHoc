/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.courseDTO;
import DTO.courseinstructorDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class courseDAL implements queryDatabase<courseDTO>{
    @Override
    public List<courseDTO> selectAll() {
    //Lấy tất cả đối tượng trong bảng  
        List<courseDTO> list = new ArrayList<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = connectSql.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM course";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL          
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                int courseID = rs.getInt("CourseID");
                String Title = rs.getString("Title");
                String Credits = rs.getString("Credits");
                int DepartmentID = rs.getInt("DepartmentID");
                
                
                courseDTO course = new courseDTO(courseID, Title, courseID, DepartmentID);
                list.add(course);
            }
            // Bước 5:
            connectSql.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }            
        return list;
    }

    @Override
    public courseDTO selectById(courseDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(courseDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insertAll(List<courseDTO> arr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(courseDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteAll(List<courseDTO> arr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(courseDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
