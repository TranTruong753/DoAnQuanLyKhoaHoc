/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.statisticDAL;
import DTO.cistatisticDTO;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class statisticBLL {
    statisticDAL CIS =new statisticDAL();
    public List<cistatisticDTO> getCISDAL() {
        return CIS.getCISDAL();
    }
}
