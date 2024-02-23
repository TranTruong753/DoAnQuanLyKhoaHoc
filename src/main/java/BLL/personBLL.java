/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.courseinstructorDAL;
import DAL.personDAL;
import DTO.courseinstructorDTO;
import DTO.personDTO;
import java.util.List;

/**
 *
 * @author Admin
 */
public class personBLL {
    personDAL person =new personDAL();
    public List<personDTO> selectAll() {
        
        List<personDTO> list = person.selectAll();
        return list;
    }
    public personDTO selectById(personDTO t) {
        return person.selectById(t);
    }
}
