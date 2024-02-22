/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import DTO.courseinstructorDTO;
import DTO.personDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.personDTO;
import java.sql.Date;
/**
 *
 * @author Admin
 */
public class personDAL implements queryDatabase<personDTO>{

    @Override
    public List<personDTO> selectAll() {
    //Lấy tất cả đối tượng trong bảng
        List<personDTO> list = new ArrayList<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = connectSql.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM person";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL          
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
               personDTO s = new personDTO();
               s.setPersonID(rs.getInt("PersonID"));
               s.setLastname(rs.getString("Lastname"));
               s.setFirstname(rs.getString("Firstname"));
               s.setHireDate(rs.getDate("HireDate"));
               s.setEnrollmentDate(rs.getDate("EnrollmentDate"));
               list.add(s);
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
    public personDTO selectById(personDTO t) {
    //Lấy 1 đối tượng trong bảng thông qua ID
        personDTO obj = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = connectSql.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM person WHERE PersonID=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getPersonID());
            // Bước 3: thực thi câu lệnh SQL          
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {        
               obj = new personDTO();
               obj.setPersonID(rs.getInt("PersonID"));
               obj.setLastname(rs.getString("Lastname"));
               obj.setFirstname(rs.getString("Firstname"));
               obj.setHireDate(rs.getDate("HireDate"));
               obj.setEnrollmentDate(rs.getDate("EnrollmentDate"));
            }
            // Bước 5:
            connectSql.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }            
        return obj;
    }

    @Override
    public int insert(personDTO t) {
    //Thêm 1 đối tượng vào bảng  
        int result = 0;
        try {
           // Bước 1: tạo kết nối đến CSDL
            Connection con = connectSql.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql="insert into person(PersonID,Lastname,Firstname,HireDate,EnrollmentDate)"
               + "VALUES(?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getPersonID());
            st.setString(2, t.getLastname());
            st.setString(3, t.getFirstname());
            st.setDate(4, (Date) t.getHireDate());
            st.setDate(5, (Date) t.getEnrollmentDate());

            // Bước 3: thực thi câu lệnh SQL          
            result = st.executeUpdate();
      
            // Bước 4: đóng kết nối
            connectSql.closeConnection(con); 
        }catch (SQLException e){
            e.printStackTrace();
        }
//        result = 0 : Thêm thất bại , result = 1 : Thêm thành công
        return result;
    }

    @Override
    public int insertAll(List<personDTO> arr) {
    //Thêm tất cả đối tượng vào bảng  
        int count = 0;
        for(personDTO item: arr) {
            count += this.insert(item);
        }
        return count ; // Đã thêm thành công count(số điếm) đối tượng
    }

    @Override
    public int delete(personDTO t) {
    //Xóa 1 đối tượng trong bảng 
        int result = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = connectSql.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "delete from person where PersonID = ?"; 

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getPersonID());
            // Bước 3: thực thi câu lệnh SQL          
            result = st.executeUpdate();        

            // Bước 4:
            connectSql.closeConnection(con);
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
//        result = 0 : Xóa thất bại , result = 1 : Xóa thành công
        return result;
    }

    @Override
    public int deleteAll(List<personDTO> arr) {
    int count = 0;
        for(personDTO item: arr) {
            count += this.delete(item);
        }
        return count ; // Đã xóa thành công count(số điếm) đối tượng
    }

    @Override
    public int update(personDTO t) {
    //Cập nhật 1 đối tượng trong bảng
        int result = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = connectSql.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE person SET Lastname = ?,Firstname = ?,HireDate = ?,EnrollmentDate = ? WHERE PersonID = ?"; 

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getLastname());
            st.setString(2, t.getFirstname());
            st.setDate(3, (Date) t.getHireDate());
            st.setDate(4, (Date) t.getEnrollmentDate());
            st.setInt(5, t.getPersonID());
            // Bước 3: thực thi câu lệnh SQL          
            result = st.executeUpdate();        

            // Bước 4:
            connectSql.closeConnection(con);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        result = 0 : update thất bại , result = 1 : update thành công
        return result;
    }
    
    
    
}
