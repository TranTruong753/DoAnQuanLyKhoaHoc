/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.personBLL;
import DTO.courseDTO;
import DTO.courseinstructorDTO;
import DTO.personDTO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class TableCourseinstructor {
    private personBLL personbll=new personBLL();
    public DefaultTableModel setTableKH(List<courseDTO> Listcourse,List<courseinstructorDTO> Listcourseinstructor, String[] listColumn){
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {        //Không được chỉnh sửa hàng và cột của bảng
                return false;
            }
            
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = Listcourse.size();
        if(rows > 0){
            for(int i = 0;i<rows;i++){
                courseDTO course = Listcourse.get(i);
                
                obj = new Object[columns];              //Mỗi phần tử trong mảng là một cột
                //obj[0] = (i+1);
                obj[0] = course.getCourseId();
                obj[1] = course.getTitle();
                obj[2] = course.getCredits();
                obj[3] = course.getDepartmentId();
                for (courseinstructorDTO Listcourseinstructor1 : Listcourseinstructor) {
                    courseinstructorDTO courseinstructor=Listcourseinstructor1;
                    if(courseinstructor.getCourseID()==course.getCourseId()){
                        obj[4] = courseinstructor.getPersonID();
                        personDTO ps=new personDTO();
                        ps.setPersonID(courseinstructor.getPersonID());
                        obj[5] = personbll.selectById(ps).getFirstname();
                        
                            
                    }
                }
                
               dtm.addRow(obj); 
            }
            
        }
        
       
        
        return dtm;
    }
    
}
