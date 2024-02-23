/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.courseDAL;
import DTO.courseDTO;
import java.util.List;

/**
 *
 * @author Admin
 */
public class courseBLL {
    courseDAL course =new courseDAL();
    public List<courseDTO> selectAll() {
        
        List<courseDTO> list = course.selectAll();
        return list;
    }
}
