/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.courseinstructorDAL;
import DTO.courseinstructorDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class courseinstructorBLL {
    courseinstructorDAL courseinstructor =new courseinstructorDAL();
    public List<courseinstructorDTO> selectAll() {
        
        List<courseinstructorDTO> list = courseinstructor.selectAll();
        return list;
    }
    public int insert(courseinstructorDTO t) {
        if(courseinstructor.insert(t)==1)
            return 1;
        return 0;
      
    }
    public int update(courseinstructorDTO t) {
        if(courseinstructor.update(t)==1)
            return 1;
        return 0;
    }
    public courseinstructorDTO selectById(courseinstructorDTO t) {
        return courseinstructor.selectById(t);
    }
    
}
