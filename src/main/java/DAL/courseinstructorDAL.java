/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import DTO.courseinstructorDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *

SELECT course.CourseID, course.Title, course.Credits, course.DepartmentID, courseinstructor.PersonID
FROM course
LEFT JOIN courseinstructor ON course.CourseID = courseinstructor.CourseID;
 */
public class courseinstructorDAL implements queryDatabase<courseinstructorDTO>{

    @Override
    public List<courseinstructorDTO> selectAll() {
    //Lấy tất cả đối tượng trong bảng  
        List<courseinstructorDTO> list = new ArrayList<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = connectSql.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM courseinstructor";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL          
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                int courseID = rs.getInt("CourseID");
                int personID = rs.getInt("PersonID");
                courseinstructorDTO courseinstructor = new courseinstructorDTO(courseID, personID);
                list.add(courseinstructor);
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
    public courseinstructorDTO selectById(courseinstructorDTO t) {
    //Lấy 1 đối tượng trong bảng thông qua ID
        courseinstructorDTO courseinstructor = null ;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = connectSql.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM courseinstructor WHERE CourseID = ? AND PersonID = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getCourseID());
            st.setInt(2, t.getPersonID());
            // Bước 3: thực thi câu lệnh SQL          
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                int courseID = rs.getInt("CourseID");
                int personID = rs.getInt("PersonID");
                courseinstructor = new courseinstructorDTO(courseID, personID);
            }
            // Bước 5:
            connectSql.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return courseinstructor;
    }

    @Override
    public int insert(courseinstructorDTO t) {
    //Thêm 1 đối tượng vào bảng  
        int result = 0;
        try {
           // Bước 1: tạo kết nối đến CSDL
            Connection con = connectSql.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO courseinstructor (CourseID, PersonID)"+ "VALUES(?,?)"; 
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getCourseID());
            st.setInt(2, t.getPersonID());
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
    public int insertAll(List<courseinstructorDTO> arr) {
    //Thêm tất cả đối tượng vào bảng  
        int count = 0;
        for(courseinstructorDTO item: arr) {
            count += this.insert(item);
        }
        return count ; // Đã thêm thành công count(số điếm) đối tượng
    }

    @Override
    public int delete(courseinstructorDTO t) {
    //Xóa 1 đối tượng trong bảng 
        int result = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = connectSql.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from courseinstructor "+
                             " WHERE CourseID=? AND PersonID=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getCourseID());
            st.setInt(2, t.getPersonID());
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
    public int deleteAll(List<courseinstructorDTO> arr) {
    //Xóa tất cả đối tượng trong bảng 
        int count = 0;
        for(courseinstructorDTO item: arr) {
            count += this.delete(item);
        }
        return count ; // Đã xóa thành công count(số điếm) đối tượng
    }

    @Override
    public int update(courseinstructorDTO t) {
    //Cập nhật 1 đối tượng trong bảng
        int result = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = connectSql.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql =  "UPDATE courseinstructor "+
                        " SET " +
                        " PersonID=?"+
                        " WHERE CourseID=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getPersonID());
            st.setInt(2, t.getCourseID());
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
    
    public static void main(String[] args) {
        courseinstructorDAL test = new courseinstructorDAL();
        courseinstructorDTO t = new courseinstructorDTO(3141,4);
        int result = test.delete(t);
        if(result == 1){
            System.out.println("Xóa thành công");
        }else {
            System.out.println("Xóa thất bại");
        }
    }
    
}
