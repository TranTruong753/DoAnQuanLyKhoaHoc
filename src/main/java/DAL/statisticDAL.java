/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.cistatisticDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class statisticDAL {
    public List<cistatisticDTO> getCISDAL() {
        Connection con = connectSql.getConnection();
        String sql = "SELECT `PersonID`, COUNT(`PersonID`) AS `Quantity` FROM `courseinstructor` GROUP BY `PersonID`;";       
        List<cistatisticDTO> list = new ArrayList<>();
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                cistatisticDTO cis = new cistatisticDTO();
                cis.setPersonID(rs.getString("PersonID"));
                cis.setQuantity(rs.getInt("Quantity"));
                list.add(cis);
            }
            st.close();
            con.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
